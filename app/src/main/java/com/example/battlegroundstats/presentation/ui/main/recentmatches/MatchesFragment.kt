package com.example.battlegroundstats.presentation.ui.main.recentmatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.battlegroundstats.databinding.FragmentMatchesListBinding

class MatchesFragment : Fragment() {

    private var _binding: FragmentMatchesListBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: MatchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}