package com.github.tumusx.maxappmvvm.clients.historicClient.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.tumusx.maxappmvvm.databinding.FragmentHistoricClientBinding

class HistoricFragment : Fragment() {
    private lateinit var binding: FragmentHistoricClientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricClientBinding.inflate(layoutInflater)
        return binding.root
    }
}