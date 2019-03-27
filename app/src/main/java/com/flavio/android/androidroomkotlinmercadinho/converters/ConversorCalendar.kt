package com.flavio.android.androidroomkotlinmercadinho.converters

import androidx.room.TypeConverter
import java.util.Calendar

class ConversorCalendar {
    @TypeConverter
    fun calendarToLong(calendar : Calendar): Long {
        return calendar.timeInMillis
    }
    @TypeConverter
    fun longToCalendar(valor : Long): Calendar{
        val momentoAtual = Calendar.getInstance()
        if(valor != null)
            momentoAtual.timeInMillis= valor
        return momentoAtual
    }
}