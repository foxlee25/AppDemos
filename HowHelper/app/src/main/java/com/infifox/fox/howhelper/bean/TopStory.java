package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jili on 2/21/17.
 */
public class TopStory implements Parcelable{

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TopStory{" +
                "ga_prefix='" + ga_prefix + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", type=" + type +
                '}';
    }

    private int id;
    private String title;
    private String ga_prefix;
    private String image;
    private int type;

    protected TopStory(Parcel in) {
        id = in.readInt();
        title = in.readString();
        ga_prefix = in.readString();
        image = in.readString();
        type = in.readInt();
    }

    public static final Creator<TopStory> CREATOR = new Creator<TopStory>() {
        @Override
        public TopStory createFromParcel(Parcel in) {
            return new TopStory(in);
        }

        @Override
        public TopStory[] newArray(int size) {
            return new TopStory[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(ga_prefix);
        dest.writeString(image);
        dest.writeInt(type);
    }
}
