package com.example.tugaspraktikum6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView tv_titleError;
    ProgressBar pb;
    Button refreshBtn;
    Button loadMoreButton;
    UserAdapter adapterUsers;
    private boolean isLoading = false;
    private boolean isFirstLoad = true;
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        tv_titleError = findViewById(R.id.tv_titleError);
        pb = findViewById(R.id.pb);
        refreshBtn = findViewById(R.id.refreshBtn);
        loadMoreButton = findViewById(R.id.loadMoreButton);

        adapterUsers = new UserAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterUsers);

        calling(currentPage);

        loadMoreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                loadMoreButton.setVisibility(View.GONE);
                if (!isLoading) {
                    isLoading = true;
                    pb.setVisibility(View.VISIBLE);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(500);
                                currentPage++;
                                loadMore();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    public void calling(int page) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        tv_titleError.setVisibility(View.GONE);
        refreshBtn.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);
        if (isFirstLoad) {
            loadMoreButton.setVisibility(View.VISIBLE);
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Call<UserResponse> client = ApiConfig.getApiService().getData(String.valueOf(currentPage));
                client.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                ArrayList<User> userResponses = response.body().getData();
                                adapterUsers.addData(userResponses);
                                pb.setVisibility(View.GONE);
                                if (isFirstLoad) {
                                    isFirstLoad = false;
                                }
                            }
                        } else {
                            if (response.body() != null) {
                                Log.e("MainActivity", "onFailure: " + response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        loadMoreButton.setVisibility(View.GONE);
                        pb.setVisibility(View.GONE);
                        tv_titleError.setVisibility(View.VISIBLE);
                        refreshBtn.setVisibility(View.VISIBLE);

                        refreshBtn.setOnClickListener(v -> {
                            pb.setVisibility(View.VISIBLE);
                            tv_titleError.setVisibility(View.GONE);
                            refreshBtn.setVisibility(View.GONE);
                            calling(currentPage);
                        });
                    }
                });
            }
        });
    }

    private void loadMore() {
        calling(currentPage);
    }
}