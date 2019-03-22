package com.gpetuhov.android.samplecustomview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorButton.setOnClickListener { myCustomView.swapColor() }
        plusButton.setOnClickListener { myCustomView.customPaddingUp(30) }
        minusButton.setOnClickListener { myCustomView.customPaddingDown(30) }
    }
}
