package com.example.lesson3.bottom_navigation

import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.lesson3.MainActivity
import com.example.lesson3.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.settings_blank.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Settings.newInstance] factory method to
 * create an instance of this fragment.
 */
class Settings : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideOtherFragments()
        val values = arrayOf("Easy", "Medium", "Hard")
        val adapter = ArrayAdapter(this.requireActivity(), R.layout.spinner_item, values)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        planets_spinner.adapter = adapter
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.settings_blank, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Settings.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Settings().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }


//    private fun radioButtonListenAndPlayMusic() {
//        val song = MediaPlayer.create(this.requireActivity(), R.raw.song)
//        radioMusic.setOnCheckedChangeListener { _, checkedId ->
//            val radioButton: View = radioMusic.findViewById(checkedId)
//            when (radioMusic.indexOfChild(radioButton)) {
//                0 -> song.start()
//                1 -> song.pause()
//            }
//        }
//    }


    private fun hideOtherFragments() {
        fragment.view?.setBackgroundColor(Color.WHITE);
    }
}



