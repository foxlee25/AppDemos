package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jili on 2/21/17.
 */

public class Comments implements Parcelable {

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    private List<Comment> comments;


    public Comments() {
    }

    protected Comments(Parcel in) {
        comments = in.createTypedArrayList(Comment.CREATOR);
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(comments);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel in) {
            return new Comments(in);
        }

        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };
}
