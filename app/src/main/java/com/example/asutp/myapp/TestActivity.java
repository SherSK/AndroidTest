package com.example.asutp.myapp;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    TextView tvTest;
    EditText edTest;
    Button btnTest;
    RadioGroup rgTest;
    RadioButton rbItem1;
    RadioButton rbItem2;
    RadioButton rbItem3;
    SharedPreferences sPref;
    private final static String TAG = "ImageManager";

final static String SAVED_TEXT="Text";
    public void tostCreate(String text, int gravity) {
        Toast toast;
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.v(TAG, "Переход в тест");
        edTest = (EditText) findViewById(R.id.edTest);
        btnTest = (Button) findViewById(R.id.btnTest);
        rgTest = (RadioGroup) findViewById(R.id.rgTest);
        rbItem1 = (RadioButton) findViewById(R.id.rbItem1);
        rbItem2 = (RadioButton) findViewById(R.id.rbItem2);
        rbItem3 = (RadioButton) findViewById(R.id.rbItem3);
        btnTest.setOnClickListener(this);
        Toast toast = Toast.makeText(this, "TEST", Toast.LENGTH_SHORT);
       // loadText();

    }
    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, edTest.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        edTest.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
      // saveText();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (rgTest.getCheckedRadioButtonId()) {
            case R.id.rbItem1:
                tostCreate("Первый элемент", Gravity.CENTER);
                saveText();
                break;
            case R.id.rbItem2:
                tostCreate("Второй элемент", Gravity.CENTER);
                loadText();
                break;
            case R.id.rbItem3:
                tostCreate("Третий элемент", Gravity.CENTER);
                break;

        }
    }
}
