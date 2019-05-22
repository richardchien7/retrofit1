package com.example.retrofit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    MyAPIService myAPIService;
    private TextView mtext_view_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext_view_result = (TextView) findViewById(R.id.text_view_result);

        //getinfor();

//        try {
//            postinfor();
//        } catch (Exception e) {
//            mtext_view_result.setText(e.toString());
//            Log.e("MainActivity", e.getMessage());//
//        }

        try {
            // deleteinfor();
        } catch (Exception e) {
            mtext_view_result.setText(e.toString());
            Log.e("MainActivity", e.getMessage());//
        }

        try {
            changeinfor();
        } catch (Exception e) {
            mtext_view_result.setText(e.toString());
            Log.e("MainActivity", e.getMessage());//
        }

    }

    public void getinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.getInfor();

        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                String id = response.body().getfieldsName();
                mtext_view_result.setText(id);
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                mtext_view_result.setText(t.getMessage());
            }
        });
    }

    public void postinfor() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.postInfor(new Req(new fields("123123", "raymondddd")));
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

    public void deleteinfor(){
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

    public void changeinfor(){
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.changeInfor(new Req(new fields("11111","111112")));
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
