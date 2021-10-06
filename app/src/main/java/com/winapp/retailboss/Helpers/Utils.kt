package com.winapp.retailboss.Helpers

import android.annotation.SuppressLint
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object  Utils {

    @SuppressLint("SimpleDateFormat")
    fun changeDateTimeStampToString(date: String?, toFormat: String):String?{
        if (date != null){
            val getPickuptime = date
            val replacePickupTime = getPickuptime.replace("/Date(", "").replace(")/", "")
            val timeInMillis = replacePickupTime.let { java.lang.Long.valueOf(it) }
            val d = (timeInMillis.div(1000)).times(1000L).let { Date(it) }
            val itemDateStr = SimpleDateFormat(toFormat).format(d)
            return itemDateStr
        }
        return null
    }


    @SuppressLint("SimpleDateFormat")
    fun convertDateStringToDefaultFormat(date: String?, fromFormat: String, toFormat: String): String?{
        if (!date.isNullOrEmpty()){
            var date = date
            var spf = SimpleDateFormat(fromFormat)
            val newDate = spf.parse(date)
            spf = SimpleDateFormat(toFormat)
            date = spf.format(newDate)
            println(date)
            return date
        }
        return null
    }


    fun getCurrentDateAndTime(): String? {
        val c = Calendar.getInstance().time
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy")
        return simpleDateFormat.format(c)
    }

    fun roundOffDecimal(number: Double): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }

     fun roundOfTotalAmount(amount: String):String?{
        val number4:Double = amount.toDouble()
        val number4s = String.format("%.2f", number4)
        return number4s
    }

    fun ShowSnakBar(msg: String, view: View){
        val snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
        snackbar.show()
    }
}