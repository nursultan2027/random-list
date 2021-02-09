package kz.nurs.randomlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.nurs.randomlist.databinding.ActivityMainBinding
import kz.nurs.randomlist.ui.ElementsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, ElementsActivity::class.java))
    }
}