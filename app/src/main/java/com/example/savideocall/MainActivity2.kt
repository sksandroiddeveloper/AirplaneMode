package com.example.savideocall
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn = findViewById<Button>(R.id.Check)
        btn.setOnClickListener {
            if(Settings.Global.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) == 0){
                Toast.makeText(applicationContext,"Off",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"On",Toast.LENGTH_SHORT).show()
            }
        }
    }
}