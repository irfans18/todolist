package com.irfams.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {

    Context context;
    ArrayList<ToDoList> toDoLists;

    public DoesAdapter (Context context, ArrayList<ToDoList> toDoLists){
        this.context = context;
        this.toDoLists = toDoLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(toDoLists.get(i).getTitledoes());
        myViewHolder.descdoes.setText(toDoLists.get(i).getDescdoes());
        myViewHolder.datedoes.setText(toDoLists.get(i).getDatedoes());
    }

    @Override
    public int getItemCount() {
        return toDoLists.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView titledoes, descdoes, datedoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView)itemView.findViewById(R.id.titledoes);
            descdoes = (TextView)itemView.findViewById(R.id.descdoes);
            datedoes = (TextView)itemView.findViewById(R.id.datedoes);

        }
    }
}
