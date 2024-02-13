package com.dexciuq.effective_mobile.presentation.screen.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.databinding.FragmentProductDetailsBinding
import com.dexciuq.effective_mobile.presentation.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private val binding by lazy { FragmentProductDetailsBinding.inflate(layoutInflater) }
    private val viewModel: ProductDetailsViewModel by viewModels()
    private val args: ProductDetailsFragmentArgs by navArgs()

    private lateinit var adapter: ProductDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getProductInfo(args.product)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        collectData()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupProductSection() {
        adapter = ProductDetailsAdapter(
            fragmentActivity = requireActivity(),
            onLikeClick = viewModel::addToFavorites,
            onUnlikeClick = viewModel::removeFromFavorites,
        )
        binding.productDetails.adapter = adapter
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.productInfo.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {}

                    is Resource.Success -> {
                        setupProductSection()
                        adapter.items = resource.data
                    }

                    is Resource.Error -> {
                        toast(resource.throwable.message)
                    }
                }
            }
        }
    }
}