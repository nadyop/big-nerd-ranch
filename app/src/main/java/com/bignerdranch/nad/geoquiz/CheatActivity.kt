package com.bignerdranch.nad.geoquiz

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView


class CheatActivity : AppCompatActivity() {

    private var mAnswerIsTrue: Boolean? = true
    private lateinit var mAnswerTextView: TextView
    private lateinit var mAnswerButton: Button

//    define keys for extras on the activities that retrieve and use them
    private val EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.nad.geoquiz.answer_is_true"
    private val EXTRA_ANSWER_SHOWN = "com.bignerdranch.nad.geoquiz.answer_shown"

    fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
        val intent = Intent(packageContext, CheatActivity::class.java)
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
        return intent
    }

    fun wasAnswerShown(result: Intent): Boolean {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        mAnswerTextView = findViewById(R.id.answer_text_view) as TextView
        mAnswerButton = findViewById(R.id.show_answer_button) as Button
        mAnswerButton.setOnClickListener {
            if (mAnswerIsTrue as Boolean) {
                mAnswerTextView.setText(R.string.true_button)
                //        mQuestionText.text = question
            } else {
                mAnswerTextView.setText(R.string.false_button)
            }
            setAnswerShownResult(true)
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent()
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        setResult(Activity.RESULT_OK, data)
    }
}
