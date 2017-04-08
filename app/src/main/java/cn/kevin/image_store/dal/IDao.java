package cn.kevin.image_store.dal;

import java.util.List;

/**
 * Created by kevin on 2016/10/26.
 */

public interface IDao<T> {
    List<T> getData();
}
