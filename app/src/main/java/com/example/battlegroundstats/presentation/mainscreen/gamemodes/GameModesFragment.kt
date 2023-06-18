package com.example.battlegroundstats.presentation.mainscreen.gamemodes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameModesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}