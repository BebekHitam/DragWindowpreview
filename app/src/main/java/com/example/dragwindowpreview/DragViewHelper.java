package com.example.dragwindowpreview;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.ref.WeakReference;

public class DragViewHelper {
    private static WeakReference<DraggableView> draggableViewRef;

    public static void showTheWindow(Activity activity) {
        // Hapus view jika sudah ada
        hideTheWindow(activity);

        // Buat instance DraggableView
        DraggableView draggableView = new DraggableView(activity);

        // Set layout parameters
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(200, 200);
        params.leftMargin = 50;
        params.topMargin = 50;
        draggableView.setLayoutParams(params);

        // Tambahkan DraggableView ke root view
        ViewGroup rootView = (ViewGroup) activity.findViewById(android.R.id.content);
        rootView.addView(draggableView);

        // Simpan referensi menggunakan WeakReference
        draggableViewRef = new WeakReference<>(draggableView);
    }

    public static void hideTheWindow(Activity activity) {
        if (draggableViewRef != null) {
            DraggableView draggableView = draggableViewRef.get();
            if (draggableView != null) {
                ViewGroup rootView = (ViewGroup) activity.findViewById(android.R.id.content);
                rootView.removeView(draggableView);
            }
            draggableViewRef.clear(); // Hapus referensi
        }
    }
}