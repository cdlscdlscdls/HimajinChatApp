package com.example.himajinchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.graphics.Color
import android.view.View
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create Button 
        val constraintLayout = findViewById(R.id.mainLayout) as ConstraintLayout
        val button = Button(this)
        button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        button.text = "Click me"
        button.setOnClickListener(View.OnClickListener {
            setContentView(R.layout.activity_sub)
        })
        button.setBackgroundColor(Color.GREEN)
        button.setTextColor(Color.RED)
        constraintLayout.addView(button);
    }
}
