package com.example.h071221048_tugas2_pma;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Title implements Parcelable {
    String Title;
    String Content;

    protected Title(Parcel in) {
        Title = in.readString();
        Content = in.readString();
    }

    public static final Creator<Title> CREATOR = new Creator<Title>() {
        @Override
        public Title createFromParcel(Parcel in) {
            return new Title(in);
        }

        @Override
        public Title[] newArray(int size) {
            return new Title[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }


    public Title(String title, String content) {
        Title = title;
        Content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Content);
    }
}
