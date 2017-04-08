package cn.kevin.image_store.entity;

import android.graphics.Bitmap;

/**
 * Created by kevin on 2016/10/26.
 */

public class Image {
    private String path;
    private int width;
    private int height;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Images[ path = "+ path +",width = "+ width +",height = "+ height+"]";
    }
}
