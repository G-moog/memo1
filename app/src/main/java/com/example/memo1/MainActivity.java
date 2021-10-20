package com.example.memo1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private mainAdapter mainAdapter;
    private RecyclerView recyclerView;

    static final int add_item = 1000;
    static final int modify_item = 1001;




    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override public void onActivityResult(ActivityResult result) {
                    switch(result.getResultCode()){
                        case add_item: Log.d("TAG", "MainActivity로 돌아왔다.");
                            String a = result.getData().getStringExtra("new_name");
                            String b = result.getData().getStringExtra("new_content");
                            mainAdapter.addarrayList(new rv_data(R.drawable.noteicon,a,b));
                            break;

                        case modify_item:Log.d("TAG", "MainActivity로 돌아왔다.");
                            String c = result.getData().getStringExtra("new_name");
                            String d = result.getData().getStringExtra("new_content");
                            int ppp = result.getData().getIntExtra("go_position",0);
                            mainAdapter.modifyList(new rv_data(R.drawable.noteicon,c,d),ppp);
                            break;

                        default : Log.d("TAG", "MainActivity로 돌아왔다.");
                    }
//                    if (result.getResultCode() == Activity.RESULT_OK) {
//                        Log.d("TAG", "MainActivity로 돌아왔다. ");
//                    }
                }
            });

    public void startWritingPage(int position, String name, String content){
        Intent intent = new Intent(MainActivity.this,writing_page.class);
        intent.putExtra("r_position", position);
        intent.putExtra("r_name", name);
        intent.putExtra("r_content", content);


        startActivityResult.launch(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.rv);



        recyclerView.setAdapter(mainAdapter);








        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,writing_page.class);
            startActivityResult.launch(intent);



//            startActivity(intent);

//                rv_data rv_data = new rv_data(R.drawable.noteicon,"고양이","야옹야옹");
//                arrayList.add(rv_data);
//                mainAdapter.notifyDataSetChanged();

            }
        });


//        Intent intent = getIntent();
//        String name = intent.getStringExtra("new_name");
//        String content = intent.getStringExtra("new_content");
//
//        rv_data rv_data1 = new rv_data(R.drawable.noteicon,name,content);
//        arrayList.add(rv_data1);
//        mainAdapter.notifyDataSetChanged();





//        mainAdapter.addarrayList(new rv_data(R.drawable.noteicon,name,content));





    }
}