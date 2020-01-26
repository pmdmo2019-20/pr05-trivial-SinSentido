package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.ExitGameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment
import java.lang.Boolean.getBoolean

class MainActivity : AppCompatActivity() {

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

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
            if(getExitDialogOption()){
                showConfirmationDialog()
            }
            else{
                super.onBackPressed()
            }
        }
        else{
            super.onBackPressed()
        }
    }

    private fun getExitDialogOption(): Boolean{
        return settings.getBoolean(
            getString(R.string.settings_showDialog),
            getBoolean("true")
        )
    }

    private fun showConfirmationDialog() {
        ExitGameFragment()
            .show(supportFragmentManager, "ConfirmationDialog")
    }
}
