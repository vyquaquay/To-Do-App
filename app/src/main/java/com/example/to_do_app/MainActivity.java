package com.example.to_do_app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_do_app.Adapter.ToDoAppAdapter;
import com.example.to_do_app.Model.TodoAppModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements DialogCloseListener{

    private RecyclerView taskRecycleview;
    private ToDoAppAdapter taskMaster;
    private List<TodoAppModel> tasklist;
    private Database db;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);
        db.openDatabase();
        //cmt to push chekc
        tasklist = new ArrayList<>();
        taskRecycleview = findViewById(R.id.tasksRecyclerView);
        taskRecycleview.setLayoutManager(new LinearLayoutManager(this));
        taskMaster = new ToDoAppAdapter(db,MainActivity.this);
        taskRecycleview.setAdapter(taskMaster);

        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecycleItemTouchHelper(taskMaster));
        itemTouchHelper.attachToRecyclerView(taskRecycleview);

        fab = findViewById(R.id.fab);


        tasklist = db.getAllTasks();
        Collections.reverse(tasklist);
        taskMaster.setTasks(tasklist);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTask.newInstance().show(getSupportFragmentManager(), AddTask.TAG);
            }
        });
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        tasklist = db.getAllTasks();
        Collections.reverse(tasklist);
        taskMaster.setTasks(tasklist);
        taskMaster.notifyDataSetChanged();
    }
    }
