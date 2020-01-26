package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.data.Question
import es.iessaladillo.pedrojoya.pr05_trivial.data.QuestionDB

class GameViewModel: ViewModel() {

    private var currentQuestion: Int = 0

    private var totalQuestions = 0

    private var questionList: MutableList<Question> = mutableListOf()

    fun startNewGame(num: Int){
        currentQuestion = 0
        totalQuestions =  num
        requestQuestions(num)
    }

    fun requestQuestions(num: Int){
        questionList = QuestionDB.getNRandomQuestions(num)
    }

    fun getCurrentQuestion(): Question{
        return questionList.get(currentQuestion)
    }

    fun nextQuestion(){
        currentQuestion++
    }

    fun isGameWon(): Boolean{
        return currentQuestion >= totalQuestions
    }
}