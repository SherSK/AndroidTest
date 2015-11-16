package com.example.asutp.myapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {
ImageView iView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        Resources res = this.getResources();
        Drawable drawable = res.getDrawable(R.drawable.photo);
        iView=(ImageView) findViewById(R.id.ivPicture);
        iView.setImageDrawable(drawable);

    }
}
