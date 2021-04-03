package com.example.lesson3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.lesson3.bottom_navigation.BlankFragment
import com.example.lesson3.bottom_navigation.BlankFragment2
import com.example.lesson3.bottom_navigation.Settings
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first_question.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.page_3 -> {
                    Toast.makeText(this, "test3", Toast.LENGTH_SHORT).show()
                    change()
                }
                R.id.page_2 -> {
                    Toast.makeText(this, "test2", Toast.LENGTH_SHORT).show()
                    change1()
                }
                R.id.page_1 ->
                    Toast.makeText(this, "test1", Toast.LENGTH_SHORT).show()
            }
            true
        }

        // bottomNavListener()
    }

    private fun change() {
        val fragment: Fragment = Settings()
        val fragmentFirst: Fragment = BlankFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.hide(fragmentFirst)
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.hide(fragmentFirst)
        fragmentTransaction.commit()
    }

    private fun change1() {
        val fragment: Fragment = BlankFragment2()
        val fragmentFirst: Fragment = Settings()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.hide(fragmentFirst)
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.hide(fragmentFirst)
        fragmentTransaction.commit()

    }

}

