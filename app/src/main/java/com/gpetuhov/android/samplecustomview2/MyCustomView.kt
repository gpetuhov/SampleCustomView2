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


// Custom attributes for our custom view are declared in values/attrs.xml file

class MyCustomView : View {

    private var paint = Paint(ANTI_ALIAS_FLAG)
    private var rect = Rect()
    private var squareColor = Color.MAGENTA
    private var padding = 0

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
        // Obtain custom attributes (initialized in xml layout file) (if any)
        if (attrs != null) {
            // Obtain custom attributes array and get color attribute value from it
            val attributesArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView)
            squareColor = attributesArray?.getColor(R.styleable.MyCustomView_square_color, Color.GREEN) ?: Color.GREEN
            paint.color = squareColor

            // Don't forget to recycle attributes array after use
            attributesArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Here we draw a rectangle on the view's canvas.
        // The size of the rectangle is the same as the size the view
        // (minus padding)
        rect.left = 0 + padding
        rect.right = width - padding
        rect.top = 0 + padding
        rect.bottom = height - padding

        canvas?.drawRect(rect, paint)

        // Notice that we should not instantiate variables in onDraw
        // (avoid using layout allocations during draw operations)
        // to avoid memory leaks.
    }

    fun swapColor() {
        paint.color = if (paint.color == squareColor) Color.RED else squareColor

        // Call this to update view
        postInvalidate()
    }

    fun customPaddingUp(padding: Int) {
        this.padding += padding
        postInvalidate()
    }

    fun customPaddingDown(padding: Int) {
        this.padding -= padding
        postInvalidate()
    }
}