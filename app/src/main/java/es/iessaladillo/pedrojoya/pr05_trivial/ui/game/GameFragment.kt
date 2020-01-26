package es.iessaladillo.pedrojoya.pr05_trivial.ui.game


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe

import es.iessaladillo.pedrojoya.pr05_trivial.R

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment(R.layout.game_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.app_name)
        }
    }
}
