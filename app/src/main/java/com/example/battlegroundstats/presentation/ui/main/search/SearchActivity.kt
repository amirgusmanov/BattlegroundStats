package com.example.battlegroundstats.presentation.ui.main.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.os.bundleOf
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.ActivitySearchBinding
import com.example.battlegroundstats.presentation.base.binding.viewBinding
import com.example.battlegroundstats.presentation.base.constants.IntentConstants
import com.example.battlegroundstats.presentation.model.UserFields
import com.example.battlegroundstats.presentation.ui.main.MainActivity

class SearchActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by viewBinding(ActivitySearchBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindViews()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.search_button -> {
                val nickname = binding.editText.text.toString().trim()
                val platform = binding.platformMenu.editText?.text.toString()
                val bundle = Bundle()
                val intent = Intent(this, MainActivity::class.java)
                bundle.putParcelable(IntentConstants.USER_FIELDS, UserFields(nickname, platform))
                intent.putExtra(IntentConstants.SEARCH_ARGS, bundle)
                startActivity(intent)
            }
        }
    }

    private fun bindViews() {
        binding.searchButton.setOnClickListener(this)
        setupPlatformSpinner()
    }

    private fun setupPlatformSpinner() {
        val platformOptions = resources.getStringArray(R.array.platform_options)
        val adapter = ArrayAdapter(this, R.layout.list_item, platformOptions)
        (binding.platformSpinner as? AutoCompleteTextView)?.setAdapter(adapter)
    }
}