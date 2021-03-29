package com.example.lesson3

import android.content.Context
import android.location.SettingInjectorService
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.settings_blank.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.page_3->{
                Toast.makeText(this, "test3", Toast.LENGTH_SHORT).show()
                    change()
                }
                R.id.page_2->
                    Toast.makeText(this, "test2", Toast.LENGTH_SHORT).show()
                R.id.page_1->
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
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.hide(fragmentFirst)
        fragmentTransaction.commit()

    }

    private fun bottomNavListener() {


        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    Toast.makeText(this, "test1", Toast.LENGTH_SHORT).show()

                }
                R.id.page_2 -> {
                    Toast.makeText(this, "test2", Toast.LENGTH_SHORT).show()
                }
                R.id.page_3 -> {
                    val fragment: Fragment = Settings()
                    val fragmentManager: FragmentManager = supportFragmentManager
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment, fragment)
                    fragmentTransaction.commit()
                }
            }
        }
    }





}