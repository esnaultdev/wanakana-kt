package dev.esnault.wanakana.android

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText
import dev.esnault.wanakana.core.Config
import dev.esnault.wanakana.core.Wanakana.toKanaIme
import dev.esnault.wanakana.core.utils.ImeText


object WanakanaAndroid {

    /**
     * Binds Wanakana to an [editText] to automagically convert the typed text to kana.
     * Uses [toKanaIme] for conversion.
     *
     * @param editText the input field to convert automatically.
     * @param config the config for the [toKanaIme] conversion, defaults to [Config.DEFAULT_IME].
     */
    @JvmStatic
    @JvmOverloads
    fun bind(editText: EditText, config: Config = Config.DEFAULT_IME): Binding {
        editText.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        return Binding(editText, config)
    }

    /**
     * A listener that is notified when the text is updated.
     *
     * Compared to adding a [TextWatcher] to the [EditText] manually, this listener will only be
     * called once for each text update, after conversion (or lack of).
     */
    fun interface Listener {

        /**
         * This method is called after the text has been changed and converted.
         */
        fun afterTextChanged(text: String?)
    }

    /**
     * Wanakana binding to an [EditText].
     */
    class Binding(
        private val editText: EditText,
        config: Config
    ) {
        /**
         * The [Config] of [toKanaIme], the conversion applied to the text.
         */
        var config: Config = config
            set(value) {
                if (value != field) {
                    field = value
                    // Convert any existing text again.
                    textWatcher?.afterTextChanged(editText.text)
                }
            }

        private var textWatcher: TextWatcher? = null
        private val listeners = mutableListOf<Listener>()

        init {
            initTextWatcher().let { textWatcher ->
                this.textWatcher = textWatcher
                editText.addTextChangedListener(textWatcher)
                // Convert any existing text during the binding.
                textWatcher.afterTextChanged(editText.text)
            }
        }

        /**
         * Adds a [listener] to be notified of text changes.
         * @param initialize if `true`, the [listener] will be called with the current value.
         */
        @JvmOverloads
        fun addListener(initialize: Boolean = false, listener: Listener) {
            listeners.add(listener)
            if (initialize) listener.afterTextChanged(editText.text?.toString())
        }

        /**
         * Removes a previously added [listener], it won't be notified of text changes anymore.
         */
        fun removeListener(listener: Listener) = listeners.remove(listener)

        /**
         * Removes all [Listener]s.
         */
        fun clearListeners() = listeners.clear()

        /**
         * Clears the binding, the text will not be converted automagically anymore.
         */
        fun clear() {
            textWatcher?.let { editText.removeTextChangedListener(it) }
            textWatcher = null
        }

        private fun notifyListeners(text: String?) {
            listeners.onEach { listener -> listener.afterTextChanged(text) }
        }

        private fun initTextWatcher() = object : TextWatcher {
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
                    notifyListeners(null)
                    return
                }
                if (text == previousText) {
                    return
                }

                val selection = editText.selectionStart..editText.selectionEnd
                val imeText = ImeText(text, selection)
                val kanaText = toKanaIme(imeText, config)
                if (kanaText.text != text) {
                    previousText = kanaText.text
                    editText.setText(kanaText.text)
                    editText.setSelection(kanaText.selection.first, kanaText.selection.last)
                    notifyListeners(kanaText.text)
                } else {
                    previousText = text
                    notifyListeners(text)
                }
            }
        }
    }
}
