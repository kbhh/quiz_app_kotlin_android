package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
class QuizQuestions : AppCompatActivity() {
    var questionView : TextView? = null;
    var questionImg : ImageView? = null;
    var progressBars : ProgressBar? = null;
    var progressTxt : TextView? = null;
    var optionOne : TextView? = null;
    var optionTwo : TextView? = null;
    var optionThree : TextView? = null;
    var optionFour : TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        questionView = findViewById(R.id.q_question);
        questionImg = findViewById(R.id.q_image);
        progressBars = findViewById(R.id.progress_bar);
        progressTxt = findViewById(R.id.progress_text);
        optionOne = findViewById(R.id.option_one);
        optionTwo = findViewById(R.id.option_two);
        optionThree = findViewById(R.id.option_three);
        optionFour = findViewById(R.id.option_four);

        var questionsList = Constants.getQuestions();

    }
}