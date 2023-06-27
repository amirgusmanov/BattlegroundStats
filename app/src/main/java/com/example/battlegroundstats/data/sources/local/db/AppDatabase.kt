package com.example.battlegroundstats.data.sources.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.battlegroundstats.data.sources.local.dao.MatchDao
import com.example.battlegroundstats.data.sources.local.dao.PlayerLifetimeDataDao
import com.example.battlegroundstats.data.sources.local.models.MatchEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeDuoDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSoloDataEntity
import com.example.battlegroundstats.data.sources.local.models.PlayerLifetimeSquadDataEntity

@Database(
    entities = [
        PlayerLifetimeDataEntity::class,
        PlayerLifetimeSoloDataEntity::class,
        PlayerLifetimeDuoDataEntity::class,
        PlayerLifetimeSquadDataEntity::class,
        MatchEntity::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerLifetimeDataDao(): PlayerLifetimeDataDao
    abstract fun matchDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDB(context).also { INSTANCE = it }
        }

        private fun buildDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "pubg_stats_database"
        ).build()
    }
}