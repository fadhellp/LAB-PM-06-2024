package com.example.praktikum4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Cat implements Parcelable {
    private String nama, username, konten;
    private Integer profile, post;
    private Uri selectedImage;

    public String getNama() {
        return nama;
    }

    public Cat(String nama, String username, String konten, Integer profile, Integer post) {
        this.nama = nama;
        this.username = username;
        this.konten = konten;
        this.profile = profile;
        this.post = post;
    }

    public Cat(String nama, String username, String konten, Integer profile, Uri selectedImage) {
        this.nama = nama;
        this.username = username;
        this.konten = konten;
        this.profile = profile;
        this.selectedImage = selectedImage;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Uri getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(Uri selectedImage) {
        this.selectedImage = selectedImage;
    }


    protected Cat(Parcel in) {
        nama = in.readString();
        username = in.readString();
        konten = in.readString();
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        selectedImage = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Cat> CREATOR = new Creator<Cat>() {
        @Override
        public Cat createFromParcel(Parcel in) {
            return new Cat(in);
        }

        @Override
        public Cat[] newArray(int size) {
            return new Cat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(username);
        dest.writeString(konten);
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        dest.writeParcelable(selectedImage, flags);
    }
}
