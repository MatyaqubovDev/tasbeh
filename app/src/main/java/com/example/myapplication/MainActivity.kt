package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var all=0
        var count=0
        val counterbtn=findViewById<Button>(R.id.counter)
        var limit=33
        val limitbtn=findViewById<Button>(R.id.limitbtn)
        val refreshbtn=findViewById<ImageButton>(R.id.refresh)
        val allView=findViewById<TextView>(R.id.all)
        val vibrator=getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        counterbtn.setOnClickListener{
            count= counterbtn.text.toString().toInt()
            count++
            if (count%33==0 && count !=0){
                Toast.makeText(this,count.toString(),Toast.LENGTH_SHORT).show()
                vibrator.vibrate(1000)
            }

            if (count>=limit){
                counterbtn.text="0"
                count=0
            }
            counterbtn.text = count.toString()
            limitbtn.text="$count/$limit"
            all++
            allView.text="Jami : $all"

        }
        limitbtn.setOnClickListener{
            when(limit){
                11->{
                    limit=33
                }
                33->{
                    limit=99
                }
                99->{
                    limit=11
                }
            }
            limitbtn.text="$count/$limit"
        }
        refreshbtn.setOnClickListener {
            all=0
            count=0
            limit=33
            counterbtn.text="0"
            allView.text="Jami : $all"
            limitbtn.text="$count/$limit"
        }
    }
}