package com.example.guessapp

object constants{

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTION:String = "total_question"
    const val CORRECT_ANSWERS:String = "correct_answer"

    fun getQuestions(): ArrayList<question>{
        val questionslist = ArrayList<question>()

        val que1 = question(1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1)

        questionslist.add(que1)

        val que2 = question(2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "New Zealand",
            "Austria",
            2)

        questionslist.add(que2)

        val que3 = question(3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Brazil",
            "Finland",
            "Belgium",
            "Fiji",
            3)

        questionslist.add(que3)

        val que4 = question(4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Bahamas",
            "Barbados",
            "Belize",
            "Brazil",
            4)

        questionslist.add(que4)

        val que5 = question(5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Finland",
            "Belgium",
            "France",
            1)

        questionslist.add(que5)

        val que6 = question(6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "Fiji",
            "New Zealand",
            "Austria",
            2)

        questionslist.add(que6)

        val que7 = question(7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Bahamas",
            "Gabon",
            "Germany",
            "Pakistan",
            3)

        questionslist.add(que7)

        val que8 = question(8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "France",
            "bangladesh",
            "Austria",
            1)

        questionslist.add(que8)

        val que9 = question(9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Brazil",
            "Kenya",
            "Kuwait",
            "Barbados",
            3)

        questionslist.add(que9)

        val que10 = question(10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "USA",
            "Australia",
            "Austria",
            "New Zealand",
            4)

        questionslist.add(que10)


        return questionslist
    }
}