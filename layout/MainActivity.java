package com.example.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLinearLayout).setOnClickListener(v ->
                startActivity(new Intent(this, LinearLayoutActivity.class)));

        findViewById(R.id.btnRelativeLayout).setOnClickListener(v ->
                startActivity(new Intent(this, RelativeLayoutActivity.class)));

        findViewById(R.id.btnConstraintLayout).setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintLayoutActivity.class)));

        findViewById(R.id.btnTableLayout).setOnClickListener(v ->
                startActivity(new Intent(this, TableLayoutActivity.class)));
        findViewById(R.id.btnFrameLayout).setOnClickListener(v ->
                startActivity(new Intent(this, FrameLayoutActivity.class)));
        findViewById(R.id.btnListLayout).setOnClickListener(v ->
                startActivity(new Intent(this, ListLayoutActivity.class)));
        findViewById(R.id.btnGridLayout).setOnClickListener(v ->
                startActivity(new Intent(this, GridLayoutActivity.class)));
        findViewById(R.id.btnWebLayout).setOnClickListener(v ->
                startActivity(new Intent(this, WebLayoutActivity.class)));
        findViewById(R.id.btnScrollView).setOnClickListener(v ->
                startActivity(new Intent(this, ScrollViewActivity.class)));
    }
}
