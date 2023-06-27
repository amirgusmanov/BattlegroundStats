package com.example.battlegroundstats.data.sources.local.mapper

interface EntityMapper<P, R> {

    fun mapFromEntity(entity: P): R

    fun mapToEntity(model: R): P

}