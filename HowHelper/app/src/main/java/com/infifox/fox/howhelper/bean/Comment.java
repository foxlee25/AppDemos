package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jili on 2/21/17.
 */

public class Comment extends AdapterBean implements Parcelable {

    private String author;
    private int id;
    private String content;
    private int likes;
    private long time;
    private String avatar;

    protected Comment(Parcel in) {
        author = in.readString();
        id = in.readInt();
        content = in.readString();
        likes = in.readInt();
        time = in.readLong();
        avatar = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeInt(id);
        dest.writeString(content);
        dest.writeInt(likes);
        dest.writeLong(time);
        dest.writeString(avatar);
    }
}
