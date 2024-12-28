package com.example.trashdetection.presentation.Deteksi

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class OverlayView(context: Context?, attrs: AttributeSet) : View(context, attrs) {
    //    private var result = listOf<>()
    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()

    private var bounds = Rect()

    init {
    }

}