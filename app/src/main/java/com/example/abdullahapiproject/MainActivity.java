package com.example.abdullahapiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelClass> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ApiInterface servics=ApiClint.getRetrofit().create(ApiInterface.class);
            Call<ModelClass> call=servics.getData();
            call.enqueue(new Callback<ModelClass>() {
                @Override
                public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                    if(response.isSuccessful()){
                        arraylist=new ArrayList<ModelClass>();
                        // arraylist = response.body();
                        arraylist.add(response.body());
                        String size= String.valueOf(arraylist.size());
                        Log.d("Size",size);
                        Toast.makeText(MainActivity.this, ""+size, Toast.LENGTH_SHORT).show();

                    }
                     else {
                        Toast.makeText(MainActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onFailure(Call<ModelClass> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception ex){}



    }
}
