package com.example.praktikum4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ImageView ivProfile;
    private TextView tvNama, tvUsername;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ivProfile = view.findViewById(R.id.iv_profile1);
        tvNama = view.findViewById(R.id.tv_nama1);
        tvUsername = view.findViewById(R.id.tv_username1);

        String nama = "Puss in Boots";
        String username = "Puss";
        int profileImageResId = R.drawable.kucing5;

        tvNama.setText(nama);
        tvUsername.setText(username);
        ivProfile.setImageResource(profileImageResId);

        Fragment fragment = new PostFragment();

        Bundle bundle = new Bundle();
        bundle.putString("nama", nama);
        bundle.putString("username", username);
        bundle.putInt("profileImageResId", profileImageResId);

        fragment.setArguments(bundle);

        return view;
    }
}
