package com.bignerdranch.nad.geoquiz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.Toast


class QuizActivity : AppCompatActivity() {

//    private var mTrueButton: Button? = null
    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mTrueButton = findViewById(R.id.true_button) as Button;
        mTrueButton.setOnClickListener {
            // make a toast on button click event
            val toast = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
        mFalseButton = findViewById(R.id.false_button) as Button;
        mFalseButton.setOnClickListener {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_LONG).show()
        }
    }
}
