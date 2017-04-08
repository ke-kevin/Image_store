package cn.kevin.image_store.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import cn.kevin.image_store.R;
import cn.kevin.image_store.adapter.ImageAdapter;
import cn.kevin.image_store.dal.IDao;
import cn.kevin.image_store.dal.ImageDaoFactory;
import cn.kevin.image_store.entity.Image;

public class MainActivity extends AppCompatActivity {
    private GridView lvImages;
    private List<Image> images;
    private ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取数据
        IDao<Image> dao = ImageDaoFactory.newInstance(this);
        images = dao.getData();


        lvImages = (GridView) findViewById(R.id.lv_images);


        adapter = new ImageAdapter(this,images);
        lvImages.setAdapter(adapter);
    }
}
