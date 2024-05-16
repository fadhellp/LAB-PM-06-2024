package com.example.h071221048_andiahmadsalwan_tugas4_fragments;

import android.net.Uri;

public class Recycle_model {
    int pf_image,image;
    String name,desc,fulldesc;
    Uri newimage;

    public Recycle_model(int pf_image, Uri newimage, String name, String desc, String fulldesc) {
        this.pf_image = pf_image;
        this.name = name;
        this.desc = desc;
        this.fulldesc = fulldesc;
        this.newimage = newimage;
    }

    public Recycle_model(int pf_image, int image, String name, String desc, String fulldesc) {
        this.pf_image = pf_image;
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.fulldesc = fulldesc;
    }

    public Uri getNewimage() {
        return newimage;
    }

    public void setNewimage(Uri newimage) {
        this.newimage = newimage;
    }

    public int getPf_image() {
        return pf_image;
    }

    public void setPf_image(int pf_image) {
        this.pf_image = pf_image;
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

    public String getFulldesc() {
        return fulldesc;
    }

    public void setFulldesc(String fulldesc) {
        this.fulldesc = fulldesc;
    }
}
