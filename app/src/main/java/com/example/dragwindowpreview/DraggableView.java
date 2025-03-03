package com.example.dragwindowpreview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class DraggableView extends FrameLayout {
    private float lastTouchX;
    private float lastTouchY;
    private boolean isDragging = false;

    public DraggableView(Context context) {
        super(context);
        init(context);
    }

    public DraggableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DraggableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        // Inflate layout XML
        LayoutInflater.from(context).inflate(R.layout.dragable_view, this, true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getRawX();
        float currentY = event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastTouchX = currentX;
                lastTouchY = currentY;
                isDragging = true;
                break;

            case MotionEvent.ACTION_MOVE:
                if (isDragging) {
                    float dx = currentX - lastTouchX;
                    float dy = currentY - lastTouchY;

                    // Perbarui posisi berdasarkan posisi saat ini
                    setX(getX() + dx);
                    setY(getY() + dy);

                    lastTouchX = currentX;
                    lastTouchY = currentY;
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isDragging = false;
                performClick(); // Memastikan event click tetap bekerja
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        // Tambahkan logika khusus jika diperlukan
        return super.performClick();
    }
}
