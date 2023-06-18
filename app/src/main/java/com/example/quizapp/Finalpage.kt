package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Finalpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalpage)

        var name:TextView = findViewById(R.id.tv_name)
        var score = findViewById<TextView>(R.id.tv_score)
        var playAgain = findViewById<Button>(R.id.btn_playAgain)
        var finish = findViewById<Button>(R.id.btn_finish)

        name.text = intent.getStringExtra(Constants.USER_NAME)
        var total_ques = intent.getIntExtra(Constants.Total_Questions,0)
        var total_score = intent.getIntExtra(Constants.User_scores,0)

        score.text = "Your Score is ${total_score} out of ${total_ques}"
        playAgain.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        finish.setOnClickListener{
            finish()
        }


    }
}