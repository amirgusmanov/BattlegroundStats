package com.example.battlegroundstats.data.sources.local.mapper

import com.example.battlegroundstats.data.sources.local.models.MatchEntity
import com.example.battlegroundstats.domain.models.Match

class LocalMatchMapper : EntityMapper<MatchEntity, Match> {

    override fun mapFromEntity(entity: MatchEntity): Match = Match(
        entity.mapName,
        entity.winPlace,
        entity.damageDealt,
        entity.kills,
        entity.gameMode,
        entity.matchTimeCreated
    )

    override fun mapToEntity(model: Match): MatchEntity = MatchEntity(
        model.mapName,
        model.winPlace,
        model.damageDealt,
        model.kills,
        model.gameMode,
        model.matchTimeCreated
    )

}