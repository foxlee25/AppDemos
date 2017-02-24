package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jili on 2/21/17.
 */

public class Latest implements Parcelable {

    private String date;
    private List<Story> stories;
    private List<TopStory> top_stories;

    protected Latest(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Latest> CREATOR = new Creator<Latest>() {
        @Override
        public Latest createFromParcel(Parcel in) {
            return new Latest(in);
        }

        @Override
        public Latest[] newArray(int size) {
            return new Latest[size];
        }
    };
}
