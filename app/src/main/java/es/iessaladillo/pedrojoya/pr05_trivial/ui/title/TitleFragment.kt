package es.iessaladillo.pedrojoya.pr05_trivial.ui.title


import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.settings.SettingsFragment

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment(R.layout.title_fragment) {

    lateinit var btnPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews(requireView())
    }

    private fun setupViews(view: View) {
        btnPlay = view.findViewById(R.id.btnPlay)
        setupAppBar()
        setupButton()
    }

    private fun setupButton() {
        btnPlay.setOnClickListener{navigateToGame()}
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            setTitle(R.string.app_name)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.title_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuAbout -> {
                navigateToAbout()
                true
            }
            R.id.mnuRules -> {
                navigateToRules()
                true
            }
            R.id.mnuSettings -> {
                navigateToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)

            }

    private fun navigateToAbout(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, AboutFragment())
            .addToBackStack("title")
            .commit()
    }

    private fun navigateToRules(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, RulesFragment())
            .addToBackStack("title")
            .commit()
    }

    private fun navigateToSettings(){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, SettingsFragment())
            .addToBackStack("title")
            .commit()
    }

    private fun navigateToGame() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, GameFragment())
            .addToBackStack("title")
            .commit()
    }


}
