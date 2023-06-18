package com.example.battlegroundstats.presentation.mainscreen.lifetime

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.battlegroundstats.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: HomeFragmentViewModel by viewModels(
        ownerProducer = { requireActivity() },
        factoryProducer = { HomeFragmentViewModel.factory() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname = arguments?.getString(ARG_NICKNAME)
        if(!nickname.isNullOrEmpty()) {
            viewModel.searchPlayerByNickname("steam", nickname)
        }
        viewModel.player.observe(viewLifecycleOwner) { player ->
//            binding.playerId.text = player.id
        }
//        viewModel.playerLifetime.observe(viewLifecycleOwner) { player ->
//            binding.playerStats.text = player.toString()
//        }
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