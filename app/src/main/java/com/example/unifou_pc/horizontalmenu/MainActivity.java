package com.example.unifou_pc.horizontalmenu;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SureDialog();

    }

    public void SureDialog(){
        final AlertDialog builder = new AlertDialog.Builder(MainActivity.this)
                .create();

     //设置弹出框加载的布局

        builder.show();
        Window window = builder.getWindow();
        window.setContentView(R.layout.dialog);

        Button btSure = (Button) window.findViewById(R.id.btSure);
        Button btCancle = (Button) window.findViewById(R.id.btCancle);

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打印

            }
        });

        btCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });
    }
}
