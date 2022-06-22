package com.example.quiz

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int = 1;
    private var mQuestionsList: ArrayList<Question>? = null;
    private var mSelectedOptionPosition: Int = 0;
    var questionView : TextView? = null;
    var questionImg : ImageView? = null;
    var progressBars : ProgressBar? = null;
    var progressTxt : TextView? = null;
    var optionOne : TextView? = null;
    var optionTwo : TextView? = null;
    var optionThree : TextView? = null;
    var optionFour : TextView? = null;
    var btnSubmit : Button? = null;
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
        btnSubmit = findViewById(R.id.btn_submit);

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        //
        mQuestionsList = Constants.getQuestions();
        setQuestion()
        defaultOptionsView();

    }

    private fun setQuestion() {
        var currentQuestion = mQuestionsList!![mCurrentPosition];
        questionView?.text = currentQuestion.question;
        progressBars?.progress = mCurrentPosition;
        progressTxt?.text = "$mCurrentPosition/${progressBars?.max}"
        questionImg?.setImageResource(currentQuestion.image);
        optionOne?.text = currentQuestion.option1
        optionTwo?.text = currentQuestion.option2
        optionThree?.text = currentQuestion.option3
        optionFour?.text = currentQuestion.option4
    }
    private fun defaultOptionsView() {
        var options = ArrayList<TextView?>();
        optionOne?.let {
            options.add(0,it)
        }
        optionTwo?.let {
            options.add(1,it)
        }
        optionThree?.let {
            options.add(2,it)
        }
        optionFour?.let {
            options.add(3,it)
        }

        for(option in options) {
            option?.setTextColor(Color.parseColor("#7a8089"));
            option?.typeface = Typeface.DEFAULT;
            option?.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg);
        }
    }
   private fun setSelectedOption(view: TextView?, option: Int) {
       defaultOptionsView();
       view?.setTextColor(Color.parseColor("#363A43"));
       view?.setTypeface(view.typeface, Typeface.BOLD);
       view?.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg);
   }
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.option_one -> {
                optionOne.let {
                    setSelectedOption(it, 1)
                }
            }
            R.id.option_two -> {
                optionTwo.let {
                    setSelectedOption(it, 2)
                }
            }
            R.id.option_three -> {
                optionThree.let {
                    setSelectedOption(it, 3)
                }
            }
            R.id.option_four -> {
            optionFour.let {
                setSelectedOption(it, 4)
            }
        }
        }
    }
}