package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.ExitGameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, TitleFragment())
                .commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        var currentFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.mainFragmentContainer)
        if(currentFragment is GameFragment){
            showConfirmationDialog()
        }
        else{
            super.onBackPressed()
        }
    }

    private fun showConfirmationDialog() {
        ExitGameFragment()
            .show(supportFragmentManager, "ConfirmationDialog")
    }
}
