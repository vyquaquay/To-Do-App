package com.example.to_do_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.to_do_app.MainActivity;
import com.example.to_do_app.Model.TodoAppModel;
import com.example.to_do_app.R;

import java.util.List;

public class ToDoAppAdapter extends RecyclerView.Adapter<ToDoAppAdapter.ViewHolder> {

    private List<TodoAppModel> todolist;
    private MainActivity activity;

    public ToDoAppAdapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        TodoAppModel item = todolist.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(riuorphay(item.getStatus()));
    }

    public int getItemCount(){
        return todolist.size();
    }
    private boolean riuorphay(int n){
        return n!=0;
    }
    public void setTask(List<TodoAppModel> todolist){
        this.todolist = todolist;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}
