package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    EditText date,name,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (EditText) findViewById(R.id.date);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
    }
    //新增儲存資料
    public void save(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        pref.edit()
                .putString("date",date.getText().toString())
                .putString("name",name.getText().toString())
                .putString("number",number.getText().toString())
                .apply();                   //或commit()
    }
    //讀取資料
    public void read(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        date.setText(pref.getString("date",""));
        name.setText(pref.getString("name",""));
        number.setText(pref.getString("number",""));
    }
    //清除EditTexts內容
    public void clear(View v){
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        date.setText("");
        name.setText("");
        number.setText("");
        //下面程式碼能清除所有資料
        /*SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();*/

    }

}