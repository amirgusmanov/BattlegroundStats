package com.example.battlegroundstats.data.sources.remote.mapper

interface ResponseMatchMapper<in P, out R> {

    fun mapFromRemote(match: P, winPlace: Int, kills: Int, damage: Double): R

}