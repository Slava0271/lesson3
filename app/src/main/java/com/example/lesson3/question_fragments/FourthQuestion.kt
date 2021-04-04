package com.example.lesson3.question_fragments

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.lesson3.ParseJSON
import com.example.lesson3.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first_question.*
import kotlinx.android.synthetic.main.fragment_fourth_question.*
import kotlinx.android.synthetic.main.fragment_third_question.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FourthQuestion.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthQuestion : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private fun hideOtherFragments() {
        fragment.view?.setBackgroundColor(Color.WHITE);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideOtherFragments()
        showQuestion()
        setImage()
        clickListenerAndChangeFragment()
    }

    private fun showQuestion(){
        textViewQuestion4.text= ParseJSON.getObjectsJSON(this.requireContext())[3].question
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FourthQuestion.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FourthQuestion().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun clickListenerAndChangeFragment() {
        button1question4.setOnClickListener() {
            seeRightAnswer()
            changeFragment()
        }
        button2question4.setOnClickListener() {
            seeRightAnswer()
            changeFragment()
        }
        button3question4.setOnClickListener() {
            changeFragment()
            seeRightAnswer()
        }
    }

    private fun seeRightAnswer() {
        button1question4.background.setColorFilter(
            ContextCompat.getColor(
                this.requireActivity(),
                R.color.red
            ), PorterDuff.Mode.MULTIPLY
        );
        button2question4.background.setColorFilter(
            ContextCompat.getColor(
                this.requireActivity(),
                R.color.red
            ), PorterDuff.Mode.MULTIPLY
        );
        button3question4.background.setColorFilter(
            ContextCompat.getColor(
                this.requireActivity(),
                R.color.green
            ), PorterDuff.Mode.MULTIPLY
        );
    }
    private fun changeFragment() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val switchFragment:Fragment=FifthQuestion()
            val fragmentManager: FragmentManager = this.requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, switchFragment)
            this.requireActivity().supportFragmentManager.executePendingTransactions();      // <----- This is the key
            fragmentTransaction.commit()        }, 2000)
    }

    private fun setImage() {
        imageViewQuestion4.setImageResource(R.drawable.question4)
    }
}