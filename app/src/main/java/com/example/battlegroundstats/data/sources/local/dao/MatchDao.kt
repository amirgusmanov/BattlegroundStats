package com.example.battlegroundstats.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.battlegroundstats.data.sources.local.models.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM `match`")
    fun getMatches(): List<MatchEntity>

    @Insert
    fun insertMatch(match: MatchEntity)

    @Query("DELETE FROM `match`")
    fun clearMatches()

}