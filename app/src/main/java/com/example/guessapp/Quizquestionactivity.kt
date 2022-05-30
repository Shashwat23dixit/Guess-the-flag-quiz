package com.example.guessapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quizquestionactivity.*
import kotlin.math.log

@Suppress("DEPRECATION")
class Quizquestionactivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName:String? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestionactivity)

        mUserName = intent.getStringExtra(constants.USER_NAME)

        mQuestionList = constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        val questions = mQuestionList!![mCurrentPosition  - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        } else{
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition " + "/" + progressBar.max

        tv_question.text = questions!!.question
        iv_image.setImageResource(questions.image)
        tv_option_one.text = questions.optionOne
        tv_option_two.text = questions.optionTwo
        tv_option_three.text = questions.optionThree
        tv_option_four.text = questions.optionFour

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)



        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defalt_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four,4)
            }

            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        } else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                             intent.putExtra(constants.USER_NAME, mUserName)
                             intent.putExtra(constants.CORRECT_ANSWERS, mCorrectAnswer)
                             intent.putExtra(constants.TOTAL_QUESTION, mQuestionList!!.size)
                             startActivity(intent)
                        }
                    }
                } else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswer ++  //To increase the mcorrectanswer by 1
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    } else{
                        btn_submit.text = "GO TO THE NEXT QUESTION".uppercase()
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer :Int, drawableView: Int){
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#A020F0"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.defalt_option_border_bg
        )
    }
}