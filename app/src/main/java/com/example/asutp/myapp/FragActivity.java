package com.example.asutp.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FragActivity extends android.support.v4.app.FragmentActivity implements View.OnClickListener{

    Button btnAdd,btnAddTwo;
    FragmentTransaction fragTransaction;
    FragmentManager fragManager;
    final String fragmentOneTag="Frag1";
    final String fragmentTwoTag="Frag2";
    OneFragment oneFragment;
    TwoFragment twoFragment;
    LinearLayout llContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ImageManager", "Зашли во фрагменты");

        setContentView(R.layout.activity_fragment);

        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnAddTwo=(Button) findViewById(R.id.btnAddTwo);
        btnAddTwo.setOnClickListener(this);

        fragManager=getFragmentManager();

        oneFragment= new OneFragment();
        twoFragment=new TwoFragment();



    }


    @Override
    public void onClick(View v) {
      switch (v.getId()) {
          case R.id.btnAdd:
              fragTransaction=fragManager.beginTransaction();
              if (fragManager.findFragmentByTag("Frag1")==null)
                    {
                        fragTransaction.add(R.id.llContainer ,oneFragment,fragmentOneTag);
                        fragTransaction.add( R.id.llContainer,twoFragment,fragmentTwoTag);
                    }
          break;
          case R.id.btnAddTwo:
              fragTransaction=fragManager.beginTransaction();
              if (fragManager.findFragmentByTag("Frag2")==null)
                    {
                        fragTransaction.add(R.id.llContainer ,twoFragment,fragmentTwoTag);
                    }
          break;


      }
        fragTransaction.commit();
    }

}
