package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jili on 2/21/17.
 */

public class Editor implements Parcelable {




    private String url;
    private String bio;
    private int id;
    private String avatar;
    private String name;

    @Override
    public String toString() {
        return "Editor{" +
                "avatar='" + avatar + '\'' +
                ", url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static Creator<Editor> getCREATOR() {
        return CREATOR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected Editor(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Editor> CREATOR = new Creator<Editor>() {
        @Override
        public Editor createFromParcel(Parcel in) {
            return new Editor(in);
        }

        @Override
        public Editor[] newArray(int size) {
            return new Editor[size];
        }
    };
}
