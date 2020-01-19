package com.example.himajinchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.graphics.Color
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG = "Firesotre"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Access a Cloud Firestore instance from your Activity
        val db = FirebaseFirestore.getInstance()
        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        // Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        // Create Button 
        val constraintLayout = findViewById(R.id.mainLayout) as ConstraintLayout
        val button = Button(this)
        button.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        button.text = "Click me"
        button.setOnClickListener(View.OnClickListener {
            db.collection("users")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }
            setContentView(R.layout.activity_sub)
        })
        button.setBackgroundColor(Color.GREEN)
        button.setTextColor(Color.RED)
        constraintLayout.addView(button);
    }
}
