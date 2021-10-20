package com.example.memo1;

import static com.example.memo1.MainActivity.add_item;
import static com.example.memo1.MainActivity.modify_item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class writing_page extends AppCompatActivity {



    private ImageButton back_button;
    private Button save_button;
    private EditText et_name;
    private EditText et_content;
    private Button image_button;


    int iv_profile;
    String tv_name;
    String tv_content;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_page);


        image_button = findViewById(R.id.image_button);

        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mIntent);


            }
        });


        et_name = findViewById(R.id.et_name);
        et_content = findViewById(R.id.et_content);
        save_button = findViewById(R.id.save_button);

//        save_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = et_name.getText().toString();
//                String content = et_content.getText().toString();
//
////                adapter.addarrayList(new rv_data(R.drawable.noteicon,name,content));
////                adapter.notifyDataSetChanged();


        Intent receive = getIntent();
        int mo_position = receive.getIntExtra("r_position",0);
        String mo_name = receive.getStringExtra("r_name");
        String mo_content = receive.getStringExtra("r_content");



        if(mo_name != null){
            et_name.setText(mo_name);
        }
        if(mo_content != null){
           et_content.setText(mo_content);
        }



        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String content = et_content.getText().toString();


                Intent send = getIntent();
//                Intent send = new Intent(writing_page.this, MainActivity.class);
//
                send.putExtra("new_name", name);
                send.putExtra("new_content", content);


//                if(mo_name == null){
                    setResult(add_item,send);
//                }else{
//                    send.putExtra("go_position",mo_position);
//                    setResult(modify_item,send);

//                }


                finish();

//
            }
        });


        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}