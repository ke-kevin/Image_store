package cn.kevin.image_store.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kevin.image_store.R;
import cn.kevin.image_store.entity.Image;

/**
 * Created by kevin on 2016/10/26.
 */

public class ImageAdapter extends BaseAdapter<Image> {
    public ImageAdapter(Context context, List<Image> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Image image = getData().get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = getLayoutInflater().inflate(R.layout.list_item_image,null);
            holder.ivImage = (ImageView)convertView.findViewById(R.id.iv_image_item_image);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //?.显示默认图片
        holder.ivImage.setImageResource(R.mipmap.ic_launcher);

        //?.开启任务：将数据显示到ViewHolder对象中的各控件变量中
        InnerTask task;
        task = tasks.get(convertView);
        if (task != null) {
            task.cancel(true);
        }

        task = new InnerTask(image,holder.ivImage);
        tasks.put(convertView,task);
        task.execute();
        return convertView;
    }
    private Map<View,InnerTask> tasks = new HashMap<View,InnerTask>();

    private class InnerTask extends AsyncTask<Void,Void,Bitmap>{
        private Image image;
        private ImageView ivImage;

        public InnerTask(Image image, ImageView ivImage) {
            super();
            this.image = image;
            this.ivImage = ivImage;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            if (image.getBitmap() == null) {
                int rate = 1;
                if (image.getWidth()>135 && image.getHeight()>135) {
                    if (image.getWidth() >image.getHeight()) {
                        rate = image.getHeight()/135;
                    }else {
                        rate = image.getWidth()/135;
                    }
                }
                BitmapFactory.Options opts =new BitmapFactory.Options();
                opts.inSampleSize = rate;
                Bitmap  bm = BitmapFactory.decodeFile(image.getPath(),opts);

                image.setBitmap(bm);

                Log.d("kevin","ImageAdapter.getView() -> position=?,image="+ image +",rate = "+ rate +",Bitmap size=" + bm.getByteCount());

            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ivImage.setImageBitmap(image.getBitmap());
        }
    }
        class ViewHolder{
            ImageView ivImage;
        }
}
