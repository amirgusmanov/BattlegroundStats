package com.example.battlegroundstats.presentation.ui.main.lifetime

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.battlegroundstats.R
import com.example.battlegroundstats.databinding.FragmentHomeBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val args: HomeFragmentArgs by navArgs()
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

        val nickname = args.nickname
        val platform = args.platform
        if (nickname.isNotEmpty()) {
            viewModel.getPlayerStats(nickname, platform)
        }

        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status!!) {
                HomeFragmentStatus.LOADING -> hideUI()
                HomeFragmentStatus.DONE -> showUI()
            }
        }

        val pieChartKD: PieChart = binding.pieChart
        val pieChartWL: PieChart = binding.winLosePieChart
        pieChartKD.setPieChart()
        pieChartWL.setPieChart()

        viewModel.playerStats.observe(viewLifecycleOwner) { playerFlow ->
            viewLifecycleOwner.lifecycleScope.launch {
                playerFlow.collect {
                    Log.d("Player", "$it")

                    bind(
                        it.kills,
                        it.losses,
                        it.hKillStreak,
                        it.damageDealt,
                        it.wins,
                        it.losses,
                        it.top10,
                        it.knocked,
                        it.headshots,
                        it.assists,
                        it.drivenDistance,
                        it.swamDistance,
                        it.walkedDistance,
                        it.longestKill,
                        it.teamKills,
                        it.suicides,
                        it.roadKills,
                        it.boosts
                    )

                    val entriesKD = listOf(
                        PieEntry(it.kills.toFloat(), "Kills"),
                        PieEntry(it.losses.toFloat(), "Deaths")
                    )
                    val entriesWL = listOf(
                        PieEntry(it.wins.toFloat(), "Wins"),
                        PieEntry(it.losses.toFloat(), "Losses")
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
                    pieChartKD.data = dataKD
                    pieChartWL.data = dataWL
                    pieChartKD.invalidate()
                    pieChartWL.invalidate()
                }
            }
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

}