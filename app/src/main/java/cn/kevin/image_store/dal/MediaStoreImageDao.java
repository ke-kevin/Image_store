package cn.kevin.image_store.dal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import cn.kevin.image_store.entity.Image;

/**
 * Created by kevin on 2016/10/26.
 */

 class MediaStoreImageDao implements IDao<Image> {
    private Context context;

    public MediaStoreImageDao(Context context) {
        super();
        this.context = context;
    }

    @Override
    public List<Image> getData() {
        List<Image> images = new ArrayList<Image>();
        ContentResolver cr = context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection={"_data","width","height"};
        Cursor c = cr.query(uri,projection,null,null,null);
        if(c.moveToFirst()){
            for(;!c.isAfterLast();c.moveToNext()){
                Image image = new Image();
                image.setPath(c.getString(0));
                image.setWidth(c.getInt(1));
                image.setHeight(c.getInt(2));
                images.add(image);
            }
        }
        if(c != null && !c.isClosed()){
            c.close();
            c=null;
        }

        return images;
    }
}
