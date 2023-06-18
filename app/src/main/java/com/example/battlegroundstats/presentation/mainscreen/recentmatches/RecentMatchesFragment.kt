package com.example.battlegroundstats.presentation.mainscreen.recentmatches

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecentMatchesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}