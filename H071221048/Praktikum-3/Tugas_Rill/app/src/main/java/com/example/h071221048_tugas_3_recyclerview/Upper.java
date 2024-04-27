package com.example.h071221048_tugas_3_recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Upper implements Parcelable {


    public String name;
    public String desc;
    Integer detailImage;
    Integer image;


    public Upper(String name, String desc, Integer detailImage, Integer image) {
        this.name = name;
        this.desc = desc;
        this.detailImage = detailImage;
        this.image = image;
    }

    protected Upper(Parcel in) {
        name = in.readString();
        desc = in.readString();
        if (in.readByte() == 0) {
            detailImage = null;
        } else {
            detailImage = in.readInt();
        }
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        if (detailImage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(detailImage);
        }
        if (image == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Upper> CREATOR = new Creator<Upper>() {
        @Override
        public Upper createFromParcel(Parcel in) {
            return new Upper(in);
        }

        @Override
        public Upper[] newArray(int size) {
            return new Upper[size];
        }
    };

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

    public Integer getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(Integer detailImage) {
        this.detailImage = detailImage;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}

//    protected Upper(Parcel in) {
//        name = in.readString();
//        if(in.readByte()==0) {
//            image = null;
//        }else {
//            image=in.readInt();
//        }
//    }
//
//    public static final Creator<Upper> CREATOR = new Creator<Upper>() {
//        @Override
//        public Upper createFromParcel(Parcel in) {
//            return new Upper(in);
//        }
//
//        @Override
//        public Upper[] newArray(int size) {
//            return new Upper[size];
//        }
//    };

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeString(name);
//        if(image==null){
//            dest.writeByte((byte)0);
//        }else {
//            dest.writeByte((byte) 1);
//            dest.writeInt(image);
//        }
//    }
//}
