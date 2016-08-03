package com.myemcu.app_7asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Ctrl+Alt+F(对象抽取)
    private Button mBtn=null;
    private TextView mTxt=null;
    private ProgressBar mBar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();    // Ctrl+Alt+M(方法抽取)

        mBtn.setOnClickListener(new View.OnClickListener() {    // Alt+Enter(实现方法)
            @Override
            public void onClick(View v) {
                DownTask downTask = new DownTask(mTxt, mBar);   // 外部类DownTask需要传递参数
                downTask.execute(100);                          // 每0.1s刷新
                Toast.makeText(MainActivity.this,"开始",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findViews() {
        mBtn = (Button)        findViewById(R.id.myBtn);
        mTxt = (TextView)      findViewById(R.id.myTxt);
        mBar = (ProgressBar)   findViewById(R.id.myBar);
    }
}
