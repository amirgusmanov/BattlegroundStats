package com.example.battlegroundstats.presentation.ui.main.lifetime

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.FragmentHomeBinding
import com.example.battlegroundstats.domain.models.Player
import com.example.battlegroundstats.presentation.ui.main.SharedViewModel
import com.example.battlegroundstats.presentation.ui.main.lifetime.HomeFragmentState.*
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val args: HomeFragmentArgs by navArgs()
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: HomeFragmentViewModel by viewModels(
        factoryProducer = { HomeFragmentViewModel.factory() }
    )
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname = args.nickname
        val platform = args.platform

        sharedViewModel.setNickname(nickname)
        sharedViewModel.setPlatform(platform)
        if (nickname.isNotEmpty()) {
            viewModel.getPlayerStats(nickname, platform)
        }
        binding.setupChart()

        viewModel.playerStats.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Loading -> {
                    hideUI()
                }
                is Error -> {
                    Snackbar.make(
                        binding.root,
                        state.error.message ?: "Something went wrong",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is Success -> {
                    val player = state.data
                    showPlayerStats(player)
                    showUI()
                }
            }
        }
    }

    private fun showPlayerStats(player: Player) = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            bind(
                player.kills, player.losses, player.hKillStreak,
                player.damageDealt, player.wins, player.losses,
                player.top10, player.knocked, player.headshots,
                player.assists, player.drivenDistance, player.swamDistance,
                player.walkedDistance, player.longestKill, player.teamKills,
                player.suicides, player.roadKills, player.boosts
            )

            val entriesKD = listOf(
                PieEntry(player.kills.toFloat(), "Kills"),
                PieEntry(player.losses.toFloat(), "Deaths")
            )
            val entriesWL = listOf(
                PieEntry(player.wins.toFloat(), "Wins"),
                PieEntry(player.losses.toFloat(), "Losses")
            )
            val colors = listOf(
                ContextCompat.getColor(requireContext(), R.color.kill),
                ContextCompat.getColor(requireContext(), R.color.death)
            )

            val dataSetKd = PieDataSet(entriesKD, "Player Statistics KD")
            dataSetKd.fix(colors)
            val dataSetWl = PieDataSet(entriesWL, "Player Statistics WL")
            dataSetWl.fix(colors)

            val dataKD = PieData(dataSetKd)
            val dataWL = PieData(dataSetWl)
            pieChart.data = dataKD
            winLosePieChart.data = dataWL
            pieChart.invalidate()
            winLosePieChart.invalidate()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bind(
        kill: Int,
        death: Int,
        hKillStreak: Int,
        dmgDealt: Double,
        winsText: Int,
        lossesText: Int,
        top10Val: Int,
        knocked: Int,
        headshots: Int,
        assists: Int,
        drivenDist: Double,
        swamDist: Double,
        walkDist: Double,
        longestKill: Double,
        teamKill: Int,
        suicide: Int,
        roadKill: Int,
        boosts: Int
    ) = with(binding) {
        kills.text = kill.toString()
        deaths.text = death.toString()
        highestKillstreak.text = hKillStreak.toString()
        damageDealtValue.text = dmgDealt.toString()
        wins.text = winsText.toString()
        losses.text = lossesText.toString()
        top10Value.text = top10Val.toString()
        knockedVal.text = knocked.toString()
        headshotsVal.text = headshots.toString()
        assistsVal.text = assists.toString()
        drivenDistanceVal.text = "$drivenDist m"
        swamDistanceVal.text = "$swamDist m"
        walkDistanceVal.text = "$walkDist m"
        longestKillVal.text = "$longestKill m"
        teamkillsVal.text = teamKill.toString()
        suicidesVal.text = suicide.toString()
        roadKillsVal.text = roadKill.toString()
        boostsVal.text = boosts.toString()


        val kdVal: Float = kill.toFloat() / death.toFloat()
        val formatted = String.format("%.2f", kdVal)
        kd.text = "KILLS DEATHS $formatted"
    }

    private fun PieChart.setPieChart() {
        setUsePercentValues(true)
        description.isEnabled = false
        legend.isEnabled = false
        holeRadius = 0f
        transparentCircleRadius = 0f
        setDrawEntryLabels(false)
    }

    private fun PieDataSet.fix(clr: List<Int>) {
        colors = clr
        selectionShift = 0f
        valueTextSize = 12f
    }

    private fun showUI() = with(binding) {
        progressBar.visibility = View.GONE
        binding.scrollView.visibility = View.VISIBLE
    }

    private fun hideUI() = with(binding) {
        progressBar.visibility = View.VISIBLE
        binding.scrollView.visibility = View.INVISIBLE
    }
    private fun FragmentHomeBinding.setupChart(){
        pieChart.setPieChart()
        winLosePieChart.setPieChart()
    }
}