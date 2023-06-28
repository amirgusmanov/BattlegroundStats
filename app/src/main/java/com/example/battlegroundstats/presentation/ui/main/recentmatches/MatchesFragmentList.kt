package com.example.battlegroundstats.presentation.ui.main.recentmatches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.battlegroundstats.databinding.FragmentMatchesListBinding
import com.example.battlegroundstats.domain.models.Match
import com.example.battlegroundstats.presentation.ui.main.SharedViewModel
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Loading
import com.example.battlegroundstats.presentation.ui.main.recentmatches.MatchesState.Success
import org.koin.androidx.viewmodel.ext.android.viewModel

class MatchesFragmentList : Fragment() {

    private val adapter = MatchRecyclerViewAdapter()
    private var _binding: FragmentMatchesListBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: MatchesViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeMatches()
        fetchMatches()
    }

    private fun observeMatches() {
        viewModel.matchesList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Loading -> {
                    binding.list.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Success -> {
                    val matches: List<Match> = state.data
                    adapter.updateList(mapMatchesToContent(matches))
                    binding.list.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun mapMatchesToContent(matches: List<Match>): List<Content> {
        return if (matches.isNotEmpty()) {
            matches.map { match ->
                Content.MatchItem(
                    mapName = match.mapName,
                    winPlace = match.winPlace,
                    damageDealt = match.damageDealt,
                    kills = match.kills,
                    gameMode = match.gameMode,
                    matchTimeCreated = match.matchTimeCreated
                )
            }
        } else {
            listOf(Content.EmptyItem)
        }
    }

    private fun fetchMatches() {
        val nickname = sharedViewModel.nickname.value
        val platform = sharedViewModel.platform.value
        viewModel.getMatches(nickname!!, platform!!)
    }

    private fun setupRecyclerView() {
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

}