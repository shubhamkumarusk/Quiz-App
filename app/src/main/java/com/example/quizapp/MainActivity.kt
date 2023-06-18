package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startbtn = findViewById<Button>(R.id.start_btn)
        var name = findViewById<EditText>(R.id.et_name)

        startbtn.setOnClickListener{
            if(name.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your name",Toast.LENGTH_LONG).show()
            }
            else{
                var intent = Intent(this,QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}