package com.example.battlegroundstats.presentation.ui.main.recentmatches

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.battlegroundstats.databinding.FragmentMatchBinding
import com.example.battlegroundstats.databinding.ViewEmptyItemBinding
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchRecyclerViewAdapter.MatchesViewHolder

class MatchRecyclerViewAdapter(
    private val values: MutableList<Content> = mutableListOf()
) : RecyclerView.Adapter<MatchesViewHolder>() {

    override fun getItemViewType(position: Int): Int = values[position].type
    override fun getItemCount(): Int = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder =
        when (viewType) {
            Content.MATCH_TYPE -> MatchViewHolder(
                FragmentMatchBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            Content.EMPTY_TYPE -> EmptyViewHolder(
                ViewEmptyItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> error("$viewType not supported yet")
        }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val item = values[position]
        when (item.type) {
            Content.MATCH_TYPE -> {
                holder as MatchViewHolder
                holder.bind(item as Content.MatchItem)
            }
        }
    }

    fun updateList(newValues: List<Content>) {
        val calculateDiff = DiffUtil.calculateDiff(MatchesListCallback(values, newValues))
        values.clear()
        values.addAll(newValues)
        calculateDiff.dispatchUpdatesTo(this)
    }

    abstract class MatchesViewHolder(view: View) : RecyclerView.ViewHolder(view)

    inner class EmptyViewHolder(binding: ViewEmptyItemBinding) : MatchesViewHolder(binding.root)

    inner class MatchViewHolder(private val binding: FragmentMatchBinding) :
        MatchesViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(match: Content.MatchItem) = with(binding) {
            mapName.text = match.mapName
            place.text = match.winPlace.toString()
            kills.text = "kills ${match.kills}"
            damage.text = "damage ${match.damageDealt}"
            gameMode.text = match.gameMode.replace('-', ' ')
            createdTime.text = match.matchTimeCreated
        }
    }

}