package com.example.memo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class open_memo extends AppCompatActivity {

    private EditText et_name;
    private EditText et_content;

    private ImageButton back_button;

    private Intent intent;
//    String m_name;
//    String m_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_page);

//        intent = getIntent();// 인텐트 받아오기
//        m_name = intent.getStringExtra("m_name"); //Adapter에서 받은 키값 연결
//        m_content = intent.getStringExtra("m_content");


        Intent intent = getIntent();
        String m_name = intent.getStringExtra("m_name");
        String m_content = intent.getStringExtra("m_content");

        et_name = findViewById(R.id.et_name);
        et_content = findViewById(R.id.et_content);
//        back_button = findViewById(R.id.back_button);

        et_name.setText(m_name);
        et_content.setText(m_content);




//        back_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//
//            }
//        });






    }
}