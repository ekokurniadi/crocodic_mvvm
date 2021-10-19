package id.ekokurniadi.myapplication.data.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverter {
    @TypeConverter
    fun accessoriesToString(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToAccessories(value: String): List<String> {
        return Gson().fromJson(value, object : TypeToken<List<String>>(){}.type)
    }
}