package com.github.tumusx.maxappmvvm.clients.charterClient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.tumusx.maxappmvvm.databinding.FragmentCharterClientBinding

class CharterFragment : Fragment() {
    private lateinit var binding: FragmentCharterClientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharterClientBinding.inflate(layoutInflater)
        return binding.root
    }
}