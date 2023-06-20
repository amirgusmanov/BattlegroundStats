package com.example.battlegroundstats.presentation.ui.main.lifetime

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.battlegroundstats.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: HomeFragmentViewModel by viewModels(
        factoryProducer = { HomeFragmentViewModel.factory() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname = arguments?.getString(ARG_NICKNAME)
        if (!nickname.isNullOrEmpty()) {
            viewModel.getPlayerStats(nickname, platform = "steam")
        }
        viewModel.playerStats.observe(viewLifecycleOwner) { playerFlow ->
            viewLifecycleOwner.lifecycleScope.launch {
                playerFlow.collect {
                    Log.d("Player", "$it")
                }
            }
        }
    }

    companion object {
        private const val ARG_NICKNAME = "nickname"

        fun newInstance(nickname: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_NICKNAME, nickname).also { fragment.arguments = args }
            return fragment
        }
    }
}