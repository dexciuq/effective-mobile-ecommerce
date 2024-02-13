package com.dexciuq.effective_mobile.presentation.utils

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dexciuq.effective_mobile.R

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun Fragment.toast(message: String?) {
    Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Int.toCount() = "($this)"

fun Int.toCountFeedback() = "$this отзыва"

fun String.toMoney(unit: String) = "$this $unit"

fun Int.toDiscountPercent() = "-$this%"

fun String.getImageById(): List<Int> = imageMap[this].orEmpty()

private val imageMap = mapOf(
    "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to listOf(R.drawable.six, R.drawable.five),
    "54a876a5-2205-48ba-9498-cfecff4baa6e" to listOf(R.drawable.one, R.drawable.two),
    "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to listOf(R.drawable.five, R.drawable.six),
    "16f88865-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.three, R.drawable.four),
    "26f88856-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.two, R.drawable.three),
    "15f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.six, R.drawable.one),
    "88f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.four, R.drawable.three),
    "55f58865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.one, R.drawable.five),
)