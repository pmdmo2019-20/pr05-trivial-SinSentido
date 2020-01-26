package es.iessaladillo.pedrojoya.pr05_trivial.ui.game


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.preference.PreferenceManager

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.Question
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won.GameWonFragment
import java.lang.reflect.Array.getInt

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment(R.layout.game_fragment) {

    lateinit var lblQuestionTitle: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radioAnswer1: RadioButton
    lateinit var radioAnswer2: RadioButton
    lateinit var radioAnswer3: RadioButton
    lateinit var radioAnswer4: RadioButton
    lateinit var btnSubmit: Button

    private val viewModel: GameViewModel by activityViewModels()

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        lblQuestionTitle = requireActivity().findViewById(R.id.lblQuestionTitle)
        radioGroup = requireActivity().findViewById(R.id.radioGroup2)
        radioAnswer1 = requireActivity().findViewById(R.id.radioAnswer1)
        radioAnswer2 = requireActivity().findViewById(R.id.radioAnswer2)
        radioAnswer3 = requireActivity().findViewById(R.id.radioAnswer3)
        radioAnswer4 = requireActivity().findViewById(R.id.radioAnswer4)
        btnSubmit = requireActivity().findViewById(R.id.btnSubmit)

        setupAppBar()
        viewModel.startNewGame(settings.getInt(
            getString(R.string.settings_numberOfQuestions),5))
        printQuestion(viewModel.getCurrentQuestion())

        btnSubmit.setOnClickListener{submitAnswer()}
    }

    private fun printQuestion(question: Question){
        lblQuestionTitle.setText(question.title)
        radioGroup.clearCheck()
        radioAnswer1.setText(question.answers[0].title)
        radioAnswer2.setText(question.answers[1].title)
        radioAnswer3.setText(question.answers[2].title)
        radioAnswer4.setText(question.answers[3].title)
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.app_name)
        }
    }

    private fun submitAnswer() {
        if(isAnyAnswerSelected()){
            if(isRightAnswer()){
                viewModel.nextQuestion()
                if(viewModel.isGameWon()){
                    navigateToGameWon()
                }
                else{
                    printQuestion(viewModel.getCurrentQuestion())
                }
            }
            else{
                navigateToGameOver()
            }
        }
    }

    private fun isAnyAnswerSelected(): Boolean {
        return (radioAnswer1.isChecked ||
                radioAnswer2.isChecked ||
                radioAnswer3.isChecked ||
                radioAnswer4.isChecked)
    }

    private fun isRightAnswer(): Boolean {
        var isRight = false;

        if(radioAnswer1.isChecked){
            if(viewModel.getCurrentQuestion().answers[0].isCorrect){
                isRight = true
            }
        }
        else if(radioAnswer2.isChecked){
            if(viewModel.getCurrentQuestion().answers[1].isCorrect){
                isRight = true
            }
        }
        else if(radioAnswer3.isChecked){
            if(viewModel.getCurrentQuestion().answers[2].isCorrect){
                isRight = true
            }
        }
        else if(radioAnswer4.isChecked){
            if(viewModel.getCurrentQuestion().answers[3].isCorrect){
                isRight = true
            }
        }

        return isRight
    }

    private fun navigateToGameOver(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, GameOverFragment())
            .commit()
    }

    private fun navigateToGameWon(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, GameWonFragment())
            .commit()
    }
}
