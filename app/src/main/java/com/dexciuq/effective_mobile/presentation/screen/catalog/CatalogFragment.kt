package com.dexciuq.effective_mobile.presentation.screen.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dexciuq.effective_mobile.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogFragment : Fragment() {

    private val binding by lazy { FragmentCatalogBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}