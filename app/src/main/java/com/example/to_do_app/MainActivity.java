package com.example.to_do_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_do_app.Adapter.ToDoAppAdapter;
import com.example.to_do_app.Model.TodoAppModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView taskRecycleview;
    private ToDoAppAdapter taskMaster;
    private List<TodoAppModel> tasklist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cmt to push chekc
        tasklist = new ArrayList<>();

        taskRecycleview = findViewById(R.id.tasksRecyclerView);
        taskRecycleview.setLayoutManager(new LinearLayoutManager(this));
        taskMaster = new ToDoAppAdapter(this);
        taskRecycleview.setAdapter(taskMaster);

        TodoAppModel task = new TodoAppModel();
        task.setTask("Test task");
        task.setStatus(0);
        task.setId(1);
        tasklist.add(task);

        taskMaster.setTask(tasklist);
        taskMaster.setTask(tasklist);
        taskMaster.setTask(tasklist);
    }

    }
