package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name = intent.getStringExtra(Constants.USER_NAME);
        val score = intent.getIntExtra(Constants.CORRECT_ANSWER, 0);
        val questions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0);

        val nameV:TextView = findViewById(R.id.name);
        val scoreV: TextView = findViewById(R.id.score);
        nameV.text = "$name";
        scoreV.text = "Your score is $score out of $questions"
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent);
        finish();
    }
}