package id.ekokurniadi.myapplication.data.room.visit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "visit")
data class Visit(
    val locationName : String,
    val date: String,
    val time: String,
    val accessories: List<String>,
    val type:String,
    val rating:Float

){


    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
