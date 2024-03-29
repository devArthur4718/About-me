package com.devarthur.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devarthur.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    // Instance of MyName data class.
    private val myName: MyName = MyName("Jimmy Hendrix")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {  addNickname(it) }
        binding.myName = myName
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameTextview.visibility = View.VISIBLE

        }

        val edittext = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_textview)
        nickNameTextView.text = edittext.text
        edittext.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE

    }

    private fun hideKeyboard(view : View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
