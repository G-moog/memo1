package com.example.memo1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.CustomViewHolder> {

    private ArrayList<rv_data> arrayList = new ArrayList<>();
    private Context context;



    @NonNull
    @Override
    public mainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override//실제 추가될 때
    public void onBindViewHolder(@NonNull mainAdapter.CustomViewHolder holder, int position) {

        rv_data item = arrayList.get(position);

        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());




        //그냥 클릭이 됐을 때
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mainAdapter.this,writing_page.class);
//                startActivity(intent);            //액티비티 이동 구문

                Intent intent;//인텐트 선언
//                intent = new Intent(context, writing_page.class); //원하는 화면 연결
//                intent.putExtra("m_name",tv_content); //변수값 인텐트로 넘기기
//                intent.putExtra("m_content",m_content);
//                context.startActivity(intent); //액티비티 열기

//
//                intent = new Intent(v.getContext(), writing_page.class);
//                intent.putExtra("m_name", holder.getAdapterPosition());
//                intent.putExtra("m_content",arrayList.get(holder.getAdapterPosition()).getTv_content());
//                v.getContext().startActivity(intent);

                ((MainActivity)v.getContext()).startWritingPage(holder.getAdapterPosition(),item.getTv_name(),item.getTv_content());



//                String curName = holder.tv_name.getText().toString();
//                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();

            }
        });

        //롱클릭 이벤트
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void addarrayList(rv_data item){

        arrayList.add(item);
        notifyDataSetChanged();

    }

    public void modifyList(rv_data item,int position){

        arrayList.set(position,item);
        notifyDataSetChanged();
    }


    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);    //새로고침. 삭제하고 난 뒤에 새로고침해라.

        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
