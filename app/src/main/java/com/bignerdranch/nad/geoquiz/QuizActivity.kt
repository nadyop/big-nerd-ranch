package com.bignerdranch.nad.geoquiz

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

//    private var mTrueButton: Button? = null
    private lateinit var mTrueButton: Button

//    private var mFalseButton: Button? = null
    private lateinit var mFalseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mTrueButton = findViewById(R.id.true_button) as Button;
        mTrueButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                public static Toast makeText(Context context, int resId, int duration);
                fun Context.toast(message: CharSequence) = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
//                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton = findViewById(R.id.false_button) as Button;
        mFalseButton.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(v1: View?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                fun Context.toast(message: CharSequence) = Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        })
    }
}
