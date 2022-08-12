package com.example.navigationapplication

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged

object Utils {

    fun String.addMandatory(): SpannableStringBuilder {
        val textdate = "$this *"
        val ssBuilder = SpannableStringBuilder(textdate)
        ssBuilder.setSpan(
            ForegroundColorSpan(Color.RED),
            textdate.length - 1,
            textdate.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return ssBuilder
    }

    fun EditText.changeDelayListener(input: (String) -> Unit): TextWatcher{
        return this.doAfterTextChanged {
            input.invoke(it.toString())
        }
    }

    inline fun myInlineFun(fn : (String) -> Unit){
        Log.e("inlineChecker", "inside")
        fn.invoke("Hello")
    }

    fun higherOrderFun(fn: () -> Unit){
        fn.invoke()
        fn()
    }

}