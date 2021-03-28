package jp.techacademy.keisuke.yoshimori.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getStringExtra("VALUE2")

        if(value2==null){
            textView.text = "$value1"
        }
        else{
            textView.text = "$value2"
        }
    }
}