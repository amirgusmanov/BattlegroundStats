package com.example.battlegroundstats.presentation.ui.main.recentmatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.battlegroundstats.R

class RecentMatchesFragment : Fragment() {

    companion object {
        fun newInstance() = RecentMatchesFragment()
    }

    private lateinit var viewModel: RecentMatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recent_matches, container, false)
    }


}