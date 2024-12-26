package com.example.todolist;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declare variables for UI component
    private EditText taskEditText;
    private Button addTaskButton;
    private ListView taskListView;

    // ArrayList to store the list of tasks
    private ArrayList<String> taskList;
    // ArrayAdapter to bind the ArrayList to the ListView
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        taskEditText = findViewById(R.id.taskEditText);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);

        // Initialize the ArrayList and ArrayAdapter
        taskList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        // Set the adapter to the ListView
        taskListView.setAdapter(arrayAdapter);

        // Set the Button onClick listener to add tasks
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskEditText.getText().toString().trim();

                // Check if the EditText is not empty
                if (!task.isEmpty()) {
                    // Add task to the list and notify adapter
                    taskList.add(task);
                    arrayAdapter.notifyDataSetChanged();
                    // Clear the EditText after adding task
                    taskEditText.setText("");
                } else {
                    // Display a message if no task is entered
                    Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
                taskListView.setOnItemClickListener((parent, view, position, id) -> {
                    // Remove the task from the list
                    taskList.remove(position);
                    // Notify the adapter that the data has changed
                    arrayAdapter.notifyDataSetChanged();
                    // Optional: Show a message that the task was removed
                    Toast.makeText(MainActivity.this, "Task removed", Toast.LENGTH_SHORT).show();
                });

            }
       });
    }
}