package com.example.battlegroundstats.data.sources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeDuoDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSoloDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSquadDataEntity

@Dao
interface PlayerLifetimeDataDao {

    @Query("SELECT * FROM player_lifetime")
    fun getPlayerTotalStats(): List<PlayerLifetimeDataEntity>

    @Query("SELECT * FROM player_lifetime_solo")
    fun getPlayerSoloStats(): List<PlayerLifetimeSoloDataEntity>

    @Query("SELECT * FROM player_lifetime_duo")
    fun getPlayerDuoStats(): List<PlayerLifetimeDuoDataEntity>

    @Query("SELECT * FROM player_lifetime_squad")
    fun getPlayerSquadStats(): List<PlayerLifetimeSquadDataEntity>

    @Query("SELECT * FROM player_lifetime WHERE id = :id")
    fun getPlayer(id: Long): Int

    @Query("DELETE FROM player_lifetime")
    fun clearTotal()

    @Query("DELETE FROM player_lifetime_solo")
    fun clearSolo()

    @Query("DELETE FROM player_lifetime_duo")
    fun clearDuo()

    @Query("DELETE FROM player_lifetime_squad")
    fun clearSquad()

    @Insert
    fun insertPlayerSolo(player: PlayerLifetimeSoloDataEntity)

    @Insert
    fun insertPlayerDuo(player: PlayerLifetimeDuoDataEntity)

    @Insert
    fun insertPlayerSquad(player: PlayerLifetimeSquadDataEntity)

}