package com.example.battlegroundstats.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeDataEntity

@Dao
interface PlayerLifetimeDataDao {

    @Query("SELECT * FROM player_lifetime")
    fun getPlayerStats(): List<PlayerLifetimeDataEntity>

    @Query("SELECT * FROM player_lifetime WHERE id = :id")
    fun getPlayer(id: Long): Int

    @Query("DELETE FROM player_lifetime")
    fun clear()

}