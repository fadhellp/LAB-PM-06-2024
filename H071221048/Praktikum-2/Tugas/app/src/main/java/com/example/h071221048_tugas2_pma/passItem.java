package com.example.h071221048_tugas2_pma;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class passItem implements Parcelable {


    String nama;
    String nim;


    public passItem(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    passItem(){}

    protected passItem(Parcel in){
        nama=in.readString();
        nim=in.readString();
//        byte[]byteArray=new byte[in.readInt()];
//        in.readByteArray(byteArray);
//        gambar= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }


    public static final Creator<passItem> CREATOR = new Creator<passItem>() {
        @Override
        public passItem createFromParcel(Parcel in) {
            return new passItem(in);
        }

        @Override
        public passItem[] newArray(int size) {
            return new passItem[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
    }
}