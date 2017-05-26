package com.example.skyrider.mobopsapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.R.color.holo_blue_light;
import static android.R.color.holo_green_light;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

/**
 * Created by skyrider on 21/5/17.
 */
//Just updated
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int itemCount;
    Context context;
    LayoutInflater inflater;
    public ArrayList<Information> data;
    MyAdapter(Context context,ArrayList<Information> data){
            this.context=context;
            this.data=data;
            inflater=LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewElement;
        CardView card;
        Button button;
        MyViewHolder(View view){
            super(view);
            textViewElement = (TextView) itemView.findViewById(R.id.textview_element);
            card = (CardView) itemView.findViewById(R.id.card_view);
            button = (Button) itemView.findViewById(R.id.button_element);
         }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutID=R.layout.row_layout;
        boolean shouldAttachToParentImmediately=false;
        View view=inflater.inflate(layoutID,parent,shouldAttachToParentImmediately);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        if((data.get(position).no)%2==0)
            holder.card.setCardBackgroundColor(Color.parseColor("#ff00ddff"));
        else
            holder.card.setCardBackgroundColor(Color.parseColor("#ff99cc00"));

        holder.textViewElement.setText(String.valueOf(data.get(position).no));

        int currentposition=position;
        final Information dataInfo=data.get(currentposition);

        holder.button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Card no "+ dataInfo.no+" collapsed.", Toast.LENGTH_SHORT).show();

                removeItem(dataInfo);

            }
        });

    }

    public void removeItem(Information dataInfo){
        int currPosition=data.indexOf(dataInfo);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
