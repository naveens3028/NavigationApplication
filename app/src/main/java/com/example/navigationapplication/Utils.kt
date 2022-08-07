package com.example.navigationapplication

import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan

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

}