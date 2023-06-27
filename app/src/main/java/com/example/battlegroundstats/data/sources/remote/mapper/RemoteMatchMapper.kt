package com.example.battlegroundstats.data.sources.remote.mapper

import com.example.battlegroundstats.data.sources.remote.models.MatchObjectResponse
import com.example.battlegroundstats.domain.models.Match

class RemoteMatchMapper : ResponseMatchMapper<MatchObjectResponse, Match> {

    override fun mapFromRemote(
        match: MatchObjectResponse,
        winPlace: Int,
        kills: Int,
        damage: Double
    ): Match = Match(
        mapName = match.mapName,
        gameMode = match.gameMode,
        matchTimeCreated = match.time,
        winPlace = winPlace,
        kills = kills,
        damageDealt = damage
    )

}