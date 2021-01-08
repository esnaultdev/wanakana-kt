package dev.esnault.wanakana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dev.esnault.wanakana.android.WanakanaAndroid

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var bindButton: Button
    private lateinit var listenerTextView: TextView
    private var binding: WanakanaAndroid.Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        bindButton = findViewById(R.id.bindButton)
        listenerTextView = findViewById(R.id.listener)

        bindButton.setOnClickListener {
            toggleBinding()
        }

        // Initialize the binding
        toggleBinding()
    }

    private fun toggleBinding() {
        val binding = binding
        if (binding != null) {
            binding.clear()
            this.binding = null
            bindButton.setText(R.string.bind)
        } else {
            this.binding = WanakanaAndroid.bind(editText).apply {
                addListener(initialize = true) { text -> listenerTextView.text = text }
            }
            bindButton.setText(R.string.unbind)
        }
    }
}
