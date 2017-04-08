package cn.kevin.image_store.dal;

import android.content.Context;

import cn.kevin.image_store.entity.Image;

/**
 * Created by kevin on 2016/10/26.
 */

public class ImageDaoFactory {
    private ImageDaoFactory() {
    }

     public static IDao<Image> newInstance(Context context){
         return new MediaStoreImageDao(context);
     }
}
