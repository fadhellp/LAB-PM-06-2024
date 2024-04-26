package com.example.h071221048_tugas_3_recyclerview;

public class Lower {
    int Ppimage,image,likes,dislikes;
    String name,desc;

    public Lower(String name, String desc,int ppimage, int image,int likes,int dislikes) {
        this.Ppimage = ppimage;
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.likes=likes;
        this.dislikes=dislikes;
    }

    public int getPpimage() {
        return Ppimage;
    }

    public void setPpimage(int ppimage) {
        Ppimage = ppimage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }
}
