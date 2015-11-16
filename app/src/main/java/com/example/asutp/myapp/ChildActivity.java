package com.example.asutp.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtName;
    TextView txtPswd;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        txtPswd=(TextView) findViewById(R.id.txtPswd);
        txtName=(TextView) findViewById(R.id.txtName);
        btnBack=(Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        Intent intent=getIntent();
        String name  = intent.getStringExtra("name");
        String pswd  = intent.getStringExtra("password");
        txtName.setText("Ваше имя: "+name);
        txtPswd.setText("Ваш пароль: "+pswd);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
