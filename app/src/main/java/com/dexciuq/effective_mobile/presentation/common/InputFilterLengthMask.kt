package com.dexciuq.effective_mobile.presentation.common

import android.text.InputFilter
import android.text.Spanned

class InputFilterLengthMask(private val mask: String) : InputFilter {

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        if (source.isNullOrEmpty()) {
            return null
        }

        val maskChar = mask[dstart]
        return if (maskChar == 'N' && !Character.isDigit(source[0])) {
            ""
        } else {
            null
        }
    }
}