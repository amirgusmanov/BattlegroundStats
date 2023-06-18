package com.example.battlegroundstats.domain.interactor

interface BaseUseCase<in P, out R> {

    suspend operator fun invoke(params: P): R

}