package com.bignerdranch.nad.geoquiz

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.content.Intent




class QuizActivity : AppCompatActivity() {

//    private var mTrueButton: Button? = null
    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button
    private lateinit var mQuestionText: TextView
    private lateinit var mNextButton: ImageView
    private lateinit var mPrevButton: ImageView
    private lateinit var mCheatButton: Button

    //    private static final String TAG = "QuizActivity"
    private var TAG: String? = "QuizActivity"
    private var KEY_INDEX: String? = "index"
    private var REQ_CODE_CHEAT: Int = 0

    private lateinit var mQuestionBank : MutableList<Question>
    private lateinit var mCheatActivity: CheatActivity
    private var mCurrentIndex = 0
    private var mIsCheater: Boolean? = true

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
        mQuestionText.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            updateQuestion()
        }
//        val question: String? = mQuestionBank[mCurrentIndex].mTextResId
//        mQuestionText.text = question

        mNextButton = findViewById(R.id.next_button) as ImageView
        mNextButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            updateQuestion()
        }

        mPrevButton = findViewById(R.id.prev_button) as ImageView
        mPrevButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.size
            updateQuestion()
        }

        mCheatButton= findViewById(R.id.cheat_button) as Button
        mCheatButton.setOnClickListener {
            val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue
            val intent = Intent(this@QuizActivity, CheatActivity::class.java)
            startActivity(intent)
            startActivityForResult(intent, REQ_CODE_CHEAT)
        }
    }

    private fun updateQuestion() {
        Log.d(TAG, "Updating question text", Exception())
        val question = mQuestionBank[mCurrentIndex].mTextResId
        mQuestionText.text = question
    }

    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue

        var messageResId = 0
        if (mIsCheater != true){
            messageResId = R.string.judgment_toast
        }else{
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast
            } else {
                messageResId = R.string.incorrect_toast
            }
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK){
            return
        }
        if (requestCode == REQ_CODE_CHEAT){
            if (data == null){
                return
            }
            mIsCheater = mCheatActivity.wasAnswerShown(data)
        }
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
