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

        val paint = Paint(ANTI_ALIAS_FLAG)
        paint.color = Color.MAGENTA
        val rect = Rect()
        rect.left = 0
        rect.right = width
        rect.top = 0
        rect.bottom = height

        canvas?.drawRect(rect, paint)
    }
}