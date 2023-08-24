package com.example.battlegroundstats.presentation.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.FragmentSearchBinding

class SearchFragment : Fragment(), View.OnClickListener {

    private lateinit var spinner: Spinner
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

        val platformOptions = resources.getStringArray(R.array.platform_options)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, platformOptions)
        (binding.platformSpinner as? AutoCompleteTextView)?.setAdapter(adapter)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.search_button -> {
                val nickname = binding.editText.text.toString().trim()
                val platform = binding.platformMenu.editText?.text.toString()
                val action = SearchFragmentDirections.actionSendName(nickname, platform)
                findNavController().navigate(action)
            }
        }
    }

}