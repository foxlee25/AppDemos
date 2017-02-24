package com.infifox.fox.howhelper.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jili on 2/21/17.
 */
public class Story extends AdapterBean implements Parcelable{
    public static final int TYPE_STORY = 0;
    public static final int TYPE_NO_IMG_STORY = 4;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public boolean isHaveImg() {
        return haveImg;
    }

    public void setHaveImg(boolean haveImg) {
        this.haveImg = haveImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static int getTypeNoImgStory() {
        return TYPE_NO_IMG_STORY;
    }

    public static int getTypeStory() {
        return TYPE_STORY;
    }

    private String title;// 新闻标题
    private List<String> images; // 图像地址（官方 API 使用数组形式。目前暂未有使用多张图片的情形出现，曾见无 images 属性的情况，请在使用中注意 ）
    private String ga_prefix; // 供 Google Analytics 使用
    //    private int type; // 作用未知
    private int id; // url 与 share_url 中最后的数字（应为内容的 id）
    private boolean multipic; // 消息是否包含多张图片（仅出现在包含多图的新闻中）
    private String date;
    private boolean isRead;
    private boolean haveImg;

    public Story(int id, String title, String image, String date, boolean multipic, boolean isRead) {

        this(id, title, image, date);
        this.multipic = multipic;
        this.isRead = isRead;
    }


    protected Story(Parcel in) {
        title = in.readString();
        images = in.createStringArrayList();
        ga_prefix = in.readString();
        id = in.readInt();
        multipic = in.readByte() != 0;
        date = in.readString();
        isRead = in.readByte() != 0;
    }


    public Story() {

    }

    public Story(String date, int showType) {
        this.date = date;
        this.showType = showType;
    }

    public Story(int id, String title, String image, String date) {
        this.id = id;
        this.title = title;
        if (image == null || image.length() == 0 || image.equals("")) {
            setShowType(Story.TYPE_NO_IMG_STORY);
            this.haveImg = false;
        } else {
            this.haveImg = true;
            images = new ArrayList<>();
            images.add(image);
        }
        this.date = date;
    }

    public Story(int typeFooter) {
        this.showType = typeFooter;
    }


    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeStringList(images);
        dest.writeString(ga_prefix);
        dest.writeInt(id);
        dest.writeByte((byte) (multipic ? 1 : 0));
        dest.writeString(date);
        dest.writeByte((byte) (isRead ? 1 : 0));
    }
}
