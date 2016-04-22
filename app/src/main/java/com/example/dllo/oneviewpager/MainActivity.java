package com.example.dllo.oneviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView img_bg;
    private MyViewPager viewPager;
    private ArrayList<String> datas;
    private VerPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBinding();
        initData();
    }

    private void setBinding(){
        viewPager = (MyViewPager) findViewById(R.id.for_viewpager);
        img_bg = (ImageView) findViewById(R.id.for_img_bg);
    }
    private void initData() {
        datas = new ArrayList<>();
        datas.add("http://e.hiphotos.baidu.com/image/pic/item/4d086e061d950a7b3ee598cd08d162d9f3d3c9e3.jpg");
        datas.add("http://a.hiphotos.baidu.com/image/pic/item/203fb80e7bec54e7ae8bcc2abc389b504fc26a9b.jpg");
        datas.add("http://e.hiphotos.baidu.com/image/pic/item/83025aafa40f4bfb27ecbf05014f78f0f73618a6.jpg");
        datas.add("http://a.hiphotos.baidu.com/image/pic/item/08f790529822720e5cc83afe79cb0a46f21fabb4.jpg");
        datas.add("http://e.hiphotos.baidu.com/image/pic/item/29381f30e924b8995d7368d66a061d950b7bf695.jpg");
        ArrayList<View> lists = new ArrayList<>();
        for (int i = 1; i < datas.size() + 1; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_for, null);
            TextView tv = (TextView) view.findViewById(R.id.for_item_tv);
            tv.setText(String.valueOf(i));
            lists.add(view);
        }
        adapter = new VerPagerAdapter(lists);
        viewPager.setMyBackGound(img_bg, datas);//设置背景图片
        viewPager.setAdapter(adapter);
        //必须下这个 要不 初始化的时候不显示 背景图片第1张
        Picasso.with(this).load(datas.get(0)).into(img_bg);
    }


}
