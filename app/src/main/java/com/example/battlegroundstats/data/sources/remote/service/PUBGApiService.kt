package com.example.battlegroundstats.data.sources.remote.service

import com.example.battlegroundstats.data.sources.remote.api.response.AttributesResponse
import com.example.battlegroundstats.data.sources.remote.api.response.BaseResponse
import com.example.battlegroundstats.data.sources.remote.api.response.PlayerResponse
import com.example.battlegroundstats.data.sources.remote.api.response.PlayerStatsResponse
import com.example.battlegroundstats.domain.models.old.RelationShipData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PUBGApiService {

    //get methods return type are time solution for test
    @GET("shards/{platform}/players")
    suspend fun searchPlayerByNickname(
        @Path("platform") platform: String,
        @Query("filter[playerNames]") playerName: String
    ): PlayerResponse

    @GET("shards/{platform}/players/{playerId}/seasons/lifetime")
    suspend fun getPlayerStats(
        @Path("platform") platform: String,
        @Path("playerId") playerId: String
    ): BaseResponse<PlayerStatsResponse>

    @GET("shards/{platform}/matches/{matchId}")
    suspend fun getMatches(
        @Path("platform") platform: String,
        @Path("matchId") matchId: String
    ): RelationShipData

}