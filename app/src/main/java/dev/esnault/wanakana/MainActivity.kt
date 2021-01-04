package dev.esnault.wanakana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import dev.esnault.wanakana.android.WanakanaAndroid

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        WanakanaAndroid.bind(editText)
    }
}
