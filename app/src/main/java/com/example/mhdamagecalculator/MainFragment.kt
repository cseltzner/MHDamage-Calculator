package com.example.mhdamagecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mhdamagecalculator.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // Starts with default dmg of 0
        val rvAdapter = CustomAdapter(viewModel.dmgList)
        binding.recyclerview.adapter = rvAdapter

        val rawString = "${getString(R.string.true_raw)} ${viewModel.trueRaw}"
        binding.rawResult.text = rawString

        binding.fab.setOnClickListener {
            val inflatedDmg = Integer.parseInt(binding.bloatedEdittext.text.toString())
            val weaponId = binding.weaponSelectSpinner.selectedItemPosition

            viewModel.trueRaw = viewModel.calculateRaw(inflatedDmg, weaponId)
            val trueRawString = "${getString(R.string.true_raw)} ${viewModel.trueRaw}"
            binding.rawResult.text = trueRawString
            viewModel.dmgList.clear()
            viewModel.dmgList.addAll(viewModel.calculateEqDmgValues(inflatedDmg, weaponId))
            rvAdapter.notifyDataSetChanged()
        }



        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}