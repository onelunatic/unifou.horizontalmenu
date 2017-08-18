package com.example.unifou_pc.horizontalmenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setDefaultFragment();
    }

//    private void setDefaultFragment() {
//        FragmentManager manager = getFragmentManager();
//
//        FragmentTransaction transaction = manager.beginTransaction();
//
//        TestFragment testFragment = new TestFragment();
//
//        transaction.replace(R.id.fl,testFragment);
//        transaction.commit();
//    }
}
