package es.iessaladillo.pedrojoya.pr05_trivial.ui.game


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment
import java.net.CacheResponse


/**
 * A simple [Fragment] subclass.
 */
class ExitGameFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =

        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.main_confirmation))
            .setMessage(getString(R.string.main_quit_game))
            .setPositiveButton(getString(R.string.main_yes)){ _, _ ->
                deleteFragment()
            }
            .setNegativeButton(getString(R.string.main_no)){ _, _ ->

            }
            .create()

    fun deleteFragment(){
        requireActivity().supportFragmentManager.popBackStack()
    }
}
