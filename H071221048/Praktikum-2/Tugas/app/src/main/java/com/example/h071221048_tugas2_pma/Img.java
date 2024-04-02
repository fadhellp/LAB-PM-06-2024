package com.example.h071221048_tugas2_pma;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Img implements Parcelable {
    byte[] image;
    public Img(byte[] image) {
        this.image = image;
    }

    protected Img(Parcel in) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            image = in.readBlob();
        }
    }

    public static final Creator<Img> CREATOR = new Creator<Img>() {
        @Override
        public Img createFromParcel(Parcel in) {
            return new Img(in);
        }

        @Override
        public Img[] newArray(int size) {
            return new Img[size];
        }
    };

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            dest.writeBlob(image);
        }
    }
}
