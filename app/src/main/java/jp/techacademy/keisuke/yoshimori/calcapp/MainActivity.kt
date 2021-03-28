package jp.techacademy.keisuke.yoshimori.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "何か数値を入力してください。", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        val intent = Intent(this, SecondActivity::class.java)
        var result : Double = 0.0
        var result2 : String ="数値が正しく入力されていません。"
        try {
            var num1: Double = (editText1.text.toString()).toDouble()
            var num2: Double = (editText2.text.toString()).toDouble()
            when (v?.id) {
                R.id.button1 -> result = num1 + num2
                R.id.button2 -> result = num1 - num2
                R.id.button3 -> result = num1 * num2
                R.id.button4 -> result = num1 / num2
            }
            intent.putExtra("VALUE1", result)
            startActivity(intent)
        }
        catch(e:NumberFormatException){
            intent.putExtra("VALUE2", result2)
            startActivity(intent)
        }
    }
}