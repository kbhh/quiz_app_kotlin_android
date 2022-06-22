package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn: Button = findViewById(R.id.startBtn);
        val name: TextView = findViewById(R.id.et_name);

        startBtn.setOnClickListener{
           if(name.text.isEmpty()) {
               Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show();
           } else {
            val intent = Intent(this,QuizQuestions::class.java);
             startActivity(intent);
               finish();
           }
        }
    }
}