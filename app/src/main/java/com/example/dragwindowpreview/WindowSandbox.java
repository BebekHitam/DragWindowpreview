package com.example.dragwindowpreview;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WindowSandbox extends AppCompatActivity {
    Button viewForWindow;

    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_sandbox);
        imageView = findViewById(R.id.green_box);

        viewForWindow = findViewById(R.id.view_for_window);
        viewForWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DragViewHelper.showTheWindow(WindowSandbox.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Hapus DraggableView saat Activity di-destroy
        DragViewHelper.hideTheWindow(this);
    }

    float x, y;
    float dx, dy;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            x = event.getRawX();
            y = event.getRawY();
            dx = x - imageView.getX();
            dy = y - imageView.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            dx = event.getX() - x;
            dy = event.getY() - y;

            imageView.setX(event.getRawX() - dx);
            imageView.setY(event.getRawY() - dy);

            x = event.getRawX();
            y= event.getRawY();
        }
        return super.onTouchEvent(event);
    }
}
