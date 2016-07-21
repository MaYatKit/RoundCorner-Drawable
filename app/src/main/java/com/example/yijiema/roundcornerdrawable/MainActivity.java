package com.example.yijiema.roundcornerdrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3;

    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(android.R.id.icon);
        imageView2 = (ImageView) findViewById(android.R.id.icon1);
        imageView3 = (ImageView) findViewById(android.R.id.icon2);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);

        imageView1.setImageDrawable(new RoundCornerDrawable(bitmap, 20, 0, RoundCornerDrawable.Type.centerCrop));
        imageView2.setImageDrawable(new RoundCornerDrawable(bitmap, 20, 0, RoundCornerDrawable.Type.fitXY));
        imageView3.setImageDrawable(new RoundCornerDrawable(bitmap, 20, 0, RoundCornerDrawable.Type.center));
    }


}
