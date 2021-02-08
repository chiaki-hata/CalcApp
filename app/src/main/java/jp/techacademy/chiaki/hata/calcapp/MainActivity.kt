package jp.techacademy.chiaki.hata.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.NumberFormatException
import kotlin.text.toDouble as toDouble

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        
        var num = 0.0

        try{
            val text1 = editText1.editableText.toString().toDouble()
            val text2 = editText2.editableText.toString().toDouble()

        when (v.id) {
            R.id.btn1 -> num = text1 + text2
            R.id.btn2 -> num = text1 - text2
            R.id.btn3 -> num = text1 * text2
            R.id.btn4 -> num = text1 / text2
        }
            intent.putExtra("VALUS1", num)
            startActivity(intent)

        } catch (e: Exception){
            Snackbar.make(v,"数値を入力してください", Snackbar.LENGTH_LONG).show()
        }

    }

}