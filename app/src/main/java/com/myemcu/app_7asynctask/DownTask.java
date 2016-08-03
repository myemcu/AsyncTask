package com.myemcu.app_7asynctask;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/3.
 */
public class DownTask extends AsyncTask<Integer,Integer,String>{

    // 定义外部类DownTask的传入变量
    private TextView tv;
    private ProgressBar pb;

    // 外部类的构造器(由外传到内)
    public DownTask(TextView tv, ProgressBar pb) {
        this.tv=tv;
        this.pb=pb;
    }

    // 再提供一个无参构造器(仅AsyncTask用)
    public DownTask() {

    }

    @Override
    //后台执行
    protected String doInBackground(Integer... params) {

        for (int i=0; i<=100; i++) {
            publishProgress(i); // 刷新进度条
            try {
                Thread.sleep(params[0]); // 传递进来的参数为100(0.1s)
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "下载完毕";
    }

    //-Ctrl+O重写如下方法----------------------------------------------------------------------------

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    // 执行完成
    protected void onPostExecute(String s) {

        tv.setText(s);                      // 显示结果
        tv.setTextColor(Color.RED);         // 设置颜色
        tv.setTextSize(20);                 // 字体大小

        pb.setVisibility(View.INVISIBLE);   // 进度条消失

        super.onPostExecute(s);             // 完成后的处理
    }

    @Override
    // 进度更新
    protected void onProgressUpdate(Integer... values) {

        tv.setText("完成当前任务的"+values[0]+"%");
        pb.setProgress(values[0]);

        tv.setVisibility(View.VISIBLE);
        pb.setVisibility(View.VISIBLE);

        super.onProgressUpdate(values);
    }
}
