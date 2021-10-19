package id.ekokurniadi.myapplication.data.room.visit

import androidx.room.*

@Dao
interface VisitDao {
    @Insert
  suspend fun insert(visit: Visit)

    @Query("SELECT * FROM visit")
   suspend fun getAll():List<Visit>

    @Update
    fun update(visit: Visit)

    @Delete
    fun delete(visit: Visit)
}