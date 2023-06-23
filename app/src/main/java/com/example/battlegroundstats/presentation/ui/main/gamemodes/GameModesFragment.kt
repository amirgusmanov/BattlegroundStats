package com.example.battlegroundstats.presentation.ui.main.gamemodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.battlegroundstats.R

class GameModesFragment : Fragment() {

    companion object {
        fun newInstance() = GameModesFragment()
    }

    private lateinit var viewModel: GameModesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_modes, container, false)
    }

}