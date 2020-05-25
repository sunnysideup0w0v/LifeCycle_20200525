package com.example.lifecycle_20200525;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lifecycle_20200525.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();

        Log.d("생명주기 확인","onCreate가 실행됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("생명주기확인","onResume실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("생명주기확인","onPause실행");
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        long now = System.currentTimeMillis();
        if(now - lastBackTime > 1000){
            Toast.makeText(mContext, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
        lastBackTime = now;
    }


    @Override
    public void setupEvents() {
        binding.moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, SecondActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void setValues() {

    }
}
