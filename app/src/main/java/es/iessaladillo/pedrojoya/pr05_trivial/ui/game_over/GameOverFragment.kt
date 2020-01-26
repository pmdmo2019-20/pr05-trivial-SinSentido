package es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment(R.layout.game_over_fragment) {
    lateinit var btnNextMatch: Button

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView(requireView())
    }

    private fun setupView(view: View) {
        btnNextMatch = view.findViewById(R.id.btnTryAgain)
        btnNextMatch.setOnClickListener{navigateToGame()}
    }

    private fun navigateToGame() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, GameFragment())
            .commit()
    }
}
