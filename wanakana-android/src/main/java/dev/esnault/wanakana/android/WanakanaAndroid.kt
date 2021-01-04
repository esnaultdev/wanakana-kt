package dev.esnault.wanakana.android

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText
import dev.esnault.wanakana.Config
import dev.esnault.wanakana.toKana


object WanakanaAndroid {

    /**
     * Binds Wanakana to an [editText] to automagically convert the typed text.
     */
    @JvmStatic
    @JvmOverloads
    fun bind(editText: EditText, config: Config = Config.DEFAULT_IME): Binding {
        editText.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS

        val textWatcher = object : TextWatcher {
            private var previousText: String? = null

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nothing to do
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nothing to do
            }

            override fun afterTextChanged(s: Editable?) {
                val text = s?.toString()
                if (text == null) {
                    previousText = null
                    return
                }
                if (text == previousText) {
                    return
                }

                val kanaText = toKana(text, config)
                if (kanaText != text) {
                    previousText = kanaText
                    editText.setText(kanaText)
                    // TODO Preserve selection
                } else {
                    previousText = text
                }
            }
        }

        editText.addTextChangedListener(textWatcher)
        return Binding(editText, textWatcher)
    }

    /**
     * Wanakana binding to an [EditText].
     * This can safely be ignored if you don't need to unbind the [EditText].
     */
    class Binding(
        private val editText: EditText,
        private val textWatcher: TextWatcher
    ) {

        /**
         * Clears the binding, the text will not be converted automagically anymore.
         */
        fun clear() {
            editText.removeTextChangedListener(textWatcher)
        }
    }
}
