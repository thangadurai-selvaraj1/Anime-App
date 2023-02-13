package com.thangadurai.animeapp.data.local.db

import androidx.room.TypeConverter

class TypeConvertor {

    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        list.forEachIndexed { index, s ->
            if (index == list.size.minus(1))
                stringBuilder.append(s)
            else
                stringBuilder.append(s).append(separator)
        }
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> =
        string.split(separator)
}