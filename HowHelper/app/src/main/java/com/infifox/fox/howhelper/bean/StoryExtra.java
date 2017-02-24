package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jili on 2/24/17.
 */

public class StoryExtra implements Parcelable {

    protected StoryExtra(Parcel in) {
        long_comments = in.readInt();
        popularity = in.readInt();
        short_comments = in.readInt();
        comments = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(long_comments);
        dest.writeInt(popularity);
        dest.writeInt(short_comments);
        dest.writeInt(comments);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoryExtra> CREATOR = new Creator<StoryExtra>() {
        @Override
        public StoryExtra createFromParcel(Parcel in) {
            return new StoryExtra(in);
        }

        @Override
        public StoryExtra[] newArray(int size) {
            return new StoryExtra[size];
        }
    };

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLong_comments() {
        return long_comments;
    }

    public void setLong_comments(int long_comments) {
        this.long_comments = long_comments;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getShort_comments() {
        return short_comments;
    }

    public void setShort_comments(int short_comments) {
        this.short_comments = short_comments;
    }

    private int long_comments;
    private int popularity;
    private int short_comments;
    private int comments;


}
