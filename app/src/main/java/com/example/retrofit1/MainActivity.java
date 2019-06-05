package com.example.retrofit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    MyAPIService myAPIService;
    private TextView mtext_view_result;
    ArrayList<Infor> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext_view_result = (TextView) findViewById(R.id.text_view_result);

        try {
            //getinfor();//這是拿取資料
        } catch (Exception e) {
            mtext_view_result.setText(e.toString() + " hello");
            Log.e("MainActivity", e.getMessage());//
        }//這是拿取資料

        try {
            // postinfor();//新增資料
        } catch (Exception e) {
            mtext_view_result.setText(e.toString());
            Log.e("MainActivity", e.getMessage());//
        }

        try {
            // deleteinfor();刪除資料
        } catch (Exception e) {
            mtext_view_result.setText(e.toString());
            Log.e("MainActivity", e.getMessage());//
        }

        try {
            changeinfor();//修改資料
        } catch (Exception e) {
            mtext_view_result.setText(e.toString());
            Log.e("MainActivity", e.getMessage());//
        }

    }

    public void getinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.getInfor();
        //mtext_view_result.setText(call.toString());

        call.enqueue(new Callback<Infor>() {//成功透過onresponse回傳 失敗用onfailure回傳
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                //String id = response.body().getfieldsName();
                // mtext_view_result.setText("success");
                for (int i = 0; i < response.body().getRecords().length; i++) {
                    mtext_view_result.append(response.body().getfieldsName(i) + "\n");
                }
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtext_view_result.setText(t.getMessage());
            }
        });
    }

    public void postinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.postInfor(new Req(new fields("richard")));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {

                mtext_view_result.setText(response.body().getfieldsName());
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtext_view_result.setText(t.getMessage());
            }
        });

    }

    public void deleteinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.deleteInfor();
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                mtext_view_result.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtext_view_result.setText(t.getMessage());
            }
        });
    }

    public void changeinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.changeInfor(new Req(new fields("richard")));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                mtext_view_result.setText("success");
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtext_view_result.setText(t.getMessage());
            }
        });
    }
}
