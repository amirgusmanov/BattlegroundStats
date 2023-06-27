package com.example.battlegroundstats.presentation.ui.main.recentmatches

import androidx.recyclerview.widget.DiffUtil

class MatchesListCallback(
    private val oldList: List<Content>,
    private val newList: List<Content>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return when {
            old is Content.MatchItem && new is Content.MatchItem ->
                old.matchTimeCreated == new.matchTimeCreated

            old is Content.EmptyItem && new is Content.EmptyItem ->
                true

            else -> false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}