package com.example.asutp.myapp;

import android.annotation.TargetApi;
import android.app.FragmentHostCallback;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edPswd;
    EditText edName;
    Button btnLogin;
    Button btnIntent;
    Button btnNotify;
    Button btnFrag;
    Button btnConnect;
    HttpURLConnection conn ;
    private final static  int NOTIFY_CODE=110;
    private final static String TAG = "ImageManager";
 //   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=(EditText) findViewById(R.id.edName);
        edPswd=(EditText) findViewById(R.id.edPswd);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnIntent= (Button) findViewById(R.id.btnIntent);
        btnNotify= (Button) findViewById(R.id.btnNotify);
        btnFrag= (Button) findViewById(R.id.btnFrag);
        btnConnect= (Button) findViewById(R.id.btnConnect);
        btnLogin.setOnClickListener(this);
        View.OnClickListener onClickListenerIntent =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, Environment.getExternalStorageDirectory().toString());
                Intent intent=new Intent(getApplicationContext(),TestActivity.class);
                startActivity(intent);
            }
        };
        btnIntent.setOnClickListener(onClickListenerIntent);
        btnNotify.setOnClickListener(this);
        btnConnect.setOnClickListener(this);
        btnFrag.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       switch (v.getId()) {
           case R.id.btnLogin:
               Intent intent = new Intent(this, ChildActivity.class);
               intent.putExtra("name", edName.getText().toString());
               intent.putExtra("password", edPswd.getText().toString());
               startActivity(intent);
               break;

           case R.id.btnNotify:
                Toast toast =Toast.makeText(this, "TEST", Toast.LENGTH_SHORT);
               toast.setGravity(Gravity.CENTER,0,0);
                Intent notifyIntent = new Intent(getApplicationContext(), PictureActivity.class);

                PendingIntent penIntent = PendingIntent.getActivity(getApplicationContext(), 20, notifyIntent, PendingIntent.FLAG_CANCEL_CURRENT);

                 Notification.Builder builder = new Notification.Builder(getApplicationContext());

                builder
                     .setContentIntent(penIntent)
                      .setSmallIcon(R.drawable.ic_launcher)
                      .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_launcher))
                      .setTicker("Новое уведомление!")
                      .setWhen(System.currentTimeMillis())
                      .setAutoCancel(true)
                      .setContentTitle("Уведомление")
                      .setContentText("Посмотреть уведомление");
                Notification notification = builder.build();
                toast.show();
                NotificationManager nm = (NotificationManager) this.getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
                nm.notify(NOTIFY_CODE, notification);
           break;

           case R.id.btnConnect:

               Log.v(TAG, Environment.getExternalStorageDirectory().toString());
//               Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//               File photo = new File(,  "Pic.jpg");
//               cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("")));
//               startActivityForResult(cameraIntent, 0);
               intent = new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("geo:" + edName.getText().toString()));
               startActivity(intent);
               break;

           case R.id.btnFrag:

               intent = new Intent(this, FragActivity.class);
               startActivity(intent);
               Log.v(TAG, "Кнопка нажата");
               break;
           //проверка GitHub
    }

    }
}
