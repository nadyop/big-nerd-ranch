package com.bignerdranch.nad.geoquiz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class QuizActivity : AppCompatActivity() {

//    private var mTrueButton: Button? = null
    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button
    private lateinit var mQuestionText: TextView
    private lateinit var mNextButton: Button

    private var TAG: String? = "QuizActivity"
//    private static final String TAG = "QuizActivity"

    private lateinit var mQuestionBank : List<Question>
    private var mCurrentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        Log.i(TAG, "oncreate")

        mTrueButton = findViewById(R.id.true_button) as Button
        mTrueButton.setOnClickListener {
            // make a toast on button click event
//            val toast = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG)
//            toast.setGravity(Gravity.TOP, 0, 0)
//            toast.show()
            checkAnswer(true)
        }
        mFalseButton = findViewById(R.id.false_button) as Button
        mFalseButton.setOnClickListener {
            checkAnswer(false)
//            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_LONG).show()
        }
        mQuestionBank = arrayListOf(Question(getString(R.string.question_australia), true), Question(getString(R.string.question_oceans), true), Question(getString(R.string.question_mideast), false), Question(getString(R.string.question_africa), false), Question(getString(R.string.question_americas), true), Question(getString(R.string.question_asia), true))
        mQuestionText = findViewById(R.id.text_question) as TextView
//        val question: String? = mQuestionBank[mCurrentIndex].mTextResId
//        mQuestionText.text = question

        mNextButton = findViewById(R.id.next_button) as Button
        mNextButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
//            val question = mQuestionBank[mCurrentIndex].mTextResId
//            mQuestionText.setText(question)
            updateQuestion()
        }
    }

    private fun updateQuestion() {
        val question = mQuestionBank[mCurrentIndex].mTextResId
        mQuestionText.text = question
    }

    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue

        var messageResId = 0

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast
        } else {
            messageResId = R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show()
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
//        val question:Question = Question(mAnswerTrue = true)
//        question.mAnswerTrue
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }
}
