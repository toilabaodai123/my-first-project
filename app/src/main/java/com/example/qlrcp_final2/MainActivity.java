package com.example.qlrcp_final2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> tenphim = new ArrayList<>();
    ArrayList<String> theloai = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("user");
            int len =   jsonArray.length();
            for(int i = 0 ;i<len;i++){
                JSONObject userData =jsonArray.getJSONObject(i);
                tenphim.add(userData.getString("tenphim"));
                theloai.add(userData.getString("theloai"));

            }
        } catch (JSONException e) {
            e.printStackTrace();

        }

        Adapter adapter = new Adapter(tenphim,theloai,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    private String JsonDataFromAsset(){
        String json = null;

        try {
            InputStream inputStream = getAssets().open("data.json");
            int sizeOfFile =inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String (bufferData,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }
}