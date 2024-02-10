package com.dexciuq.effective_mobile.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dexciuq.effective_mobile.databinding.FragmentDiscountBinding

class DiscountFragment : Fragment() {

    private lateinit var binding: FragmentDiscountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiscountBinding.inflate(inflater, container, false)
        return binding.root
    }
}