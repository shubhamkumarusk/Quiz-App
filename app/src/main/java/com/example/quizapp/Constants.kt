package com.example.quizapp

object Constants {
    const val USER_NAME :String ="userName"
    const val Total_Questions:String  = "totalques"
    const val User_scores:String = "score"
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val ques1 = Question(
            1,"What country does this flag belongs to?",
            R.drawable.flag_of_antarctica,
            "Austria",
            "Canada",
            "Antarctica",
            "Africa",
            3
        )
        questionsList.add(ques1)


        val ques2 = Question(
            2,"What country does this flag belongs to?",
            R.drawable.flag_of_argentina,
            "Argentina",
            "India",
            "United State",
            "Wales",
            1
        )
        questionsList.add(ques2)

        val ques3 = Question(
            3,"What country does this flag belongs to?",
            R.drawable.flag_of_india,
            "Egypt",
            "India",
            "Antarctica",
            "Finland",
            2
        )
        questionsList.add(ques3)


        val ques4 = Question(
            4,"What country does this flag belongs to?",
            R.drawable.flag_of_brazil,
            "Pakistan",
            "Egypt",
            "Brazil",
            "Argentina",
            3
        )
        questionsList.add(ques4)


        val ques5 = Question(
            5,"What country does this flag belongs to?",
            R.drawable.flag_of_austria,
            "Austria",
            "Nepal",
            "France",
            "Japan",
            1
        )
        questionsList.add(ques5)


        val ques6 = Question(
            6,"What country does this flag belongs to?",
            R.drawable.flag_of_finland,
            "Austria",
            "Finland",
            "Antarctica",
            "Colombia",
            2
        )
        questionsList.add(ques6)


        val ques7 = Question(
            7,"What country does this flag belongs to?",
            R.drawable.flag_of_canada,
            "Austria",
            "Canada",
            "Antarctica",
            "Africa",
            2
        )
        questionsList.add(ques7)


        val ques8 = Question(
            8,"What country does this flag belongs to?",
            R.drawable.flag_of_egypt,
            "Sri Lanka",
            "Egypt",
            "Germany",
            "San Marino",
            2
        )
        questionsList.add(ques8)


        val ques9 = Question(
            9,"What country does this flag belongs to?",
            R.drawable.flag_of_united_states,
            "Colombia",
            "Canada",
            "Philippines",
            "United State",
            4
        )
        questionsList.add(ques9)


        val ques10 = Question(
            10,"What country does this flag belongs to?",
            R.drawable.flag_of_wales,
            "Afghanistan",
            "Wales",
            "Serbia",
            "Portugal",
            2
        )
        questionsList.add(ques10)






        return questionsList
    }

}