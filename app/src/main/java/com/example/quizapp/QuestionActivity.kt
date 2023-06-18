package com.example.quizapp

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var ques:TextView? = null
    private var progressbar : ProgressBar? =null
    private var flagimage: ImageView?=null
    private var progressBartxt: TextView? = null
    private var opt1 :TextView?=null
    private var opt2 :TextView?=null
    private var opt3 :TextView?=null
    private var opt4 :TextView?=null
    private var musername:String? =null
    private var mCorrectAnswer: Int =0;

    var mcurrPostion:Int = 1
    var mQuestion :ArrayList<Question>?=null
    var mSelectedOption: Int =0
    var submitbtn:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        ques = findViewById(R.id.question)
        progressbar = findViewById(R.id.progressbar)
        flagimage = findViewById(R.id.flagimage)
        progressBartxt = findViewById(R.id.solved)
        submitbtn= findViewById(R.id.submitbutton)

        opt1 = findViewById(R.id.option1)
        opt2 = findViewById(R.id.option2)
        opt3 = findViewById(R.id.option3)
        opt4 = findViewById(R.id.option4)


        opt1?.setOnClickListener(this)
        opt2?.setOnClickListener(this)
        opt3?.setOnClickListener(this)
        opt4?.setOnClickListener(this)
        submitbtn?.setOnClickListener(this)

        musername = intent.getStringExtra(Constants.USER_NAME)

        mQuestion = Constants.getQuestions()


        setQuestions()



    }

    private fun setQuestions() {
        defalutOption()
        var questions: Question = mQuestion!![mcurrPostion - 1]
        progressbar?.progress = mcurrPostion
        progressBartxt?.text = "${mcurrPostion}/${progressbar?.max}"
        ques?.text = questions.question
        flagimage?.setImageResource(questions.image)
        opt1?.text = questions.optionOne
        opt2?.text = questions.optionTwo
        opt3?.text = questions.optionThree
        opt4?.text = questions.optionFour

        if(mcurrPostion==mQuestion!!.size){
            submitbtn?.text="FINISH"
        }
        else{
            submitbtn?.text="Submit"
        }
    }

    private fun defalutOption(){
        val options  = ArrayList<TextView>()
        opt1?.let{
            options.add(it);

        }
        opt2?.let{
            options.add(it);

        }
        opt3?.let{
            options.add(it);

        }
        opt4?.let{
            options.add(it);

        }

        for(opt in options){
            opt.setTextColor(Color.parseColor("#7A8089"))
            opt.typeface = Typeface.DEFAULT
            opt.background = ContextCompat.getDrawable(
                this,
                R.drawable.boarder
            )
        }


    }

    private fun selectedOption(tv: TextView, selectedOptNumber:Int ){
        defalutOption()
        mSelectedOption = selectedOptNumber
        tv.setTextColor(Color.parseColor("#141314"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selectedoption
        )

    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 ->{
                opt1?.let{
                    selectedOption(it,1)
                }
            }

            R.id.option2 -> {
                opt2?.let{
                    selectedOption(it,2)
                }
            }

            R.id.option3 ->{
                opt3?.let{
                    selectedOption(it,3)
                }
            }

            R.id.option4 ->{
                opt4?.let{
                    selectedOption(it,4)
                }
            }
            R.id.submitbutton->{
                if(mSelectedOption == 0){
                    mcurrPostion++
                    when{
                        mcurrPostion<=mQuestion!!.size->{
                            setQuestions()
                        }

                        else->{
                            var intent = Intent(this,Finalpage::class.java)
                            intent.putExtra(Constants.USER_NAME,musername)
                            intent.putExtra(Constants.User_scores,mCorrectAnswer)
                            intent.putExtra(Constants.Total_Questions,mQuestion!!.size)
                            startActivity(intent)
                        }

                    }
                }
                else{
                    val question = mQuestion?.get(mcurrPostion-1)
                    if(question!!.correctAns!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.wrond_option)
                    }
                    else{
                        mCorrectAnswer++;
                    }
                    answerView(question.correctAns,R.drawable.correct_options)
                    if(mcurrPostion==mQuestion!!.size){
                        submitbtn?.text = "FINISH"


                    }
                    else{
                        submitbtn?.text = "NEXT"
                    }
                    mSelectedOption =0;

                }
            }
        }




    }

    private fun answerView(answer:Int, drawableView: Int){
        when(answer){
            1-> {
                opt1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2-> {
                opt2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3-> {
                opt3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4-> {
                opt4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}