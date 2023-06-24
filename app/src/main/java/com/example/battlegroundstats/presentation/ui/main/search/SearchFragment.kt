package com.example.battlegroundstats.presentation.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.FragmentSearchBinding

class SearchFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.search_button -> {
                val nickname = binding.editText.text.toString().trim()
                val platform: String = when (binding.radioBtnGroup.checkedRadioButtonId) {
                    R.id.steam_btn -> "steam"
                    R.id.psn_btn -> "psn"
                    R.id.xbox_btn -> "xbox"
                    else -> { "steam" }
                }
                val action = SearchFragmentDirections.actionSendName(nickname, platform)
                findNavController().navigate(action)
            }
        }
    }

}