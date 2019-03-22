package com.gpetuhov.android.samplecustomview2

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Rect


class MyCustomView : View {

    private var paint = Paint(ANTI_ALIAS_FLAG)
    private var rect = Rect()

    // Our custom view class has no primary constructor,
    // only secondary constructors, that call the corresponding
    // constructors of the super class.

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        // TODO: implement
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Here we draw a rectangle on the view's canvas.
        // The size of the rectangle is the same as the size the view.
        paint.color = Color.MAGENTA
        rect.left = 0
        rect.right = width
        rect.top = 0
        rect.bottom = height

        canvas?.drawRect(rect, paint)

        // Notice that we should not instantiate variables in onDraw
        // (avoid using layout allocations during draw operations)
        // to avoid memory leaks.
    }
}