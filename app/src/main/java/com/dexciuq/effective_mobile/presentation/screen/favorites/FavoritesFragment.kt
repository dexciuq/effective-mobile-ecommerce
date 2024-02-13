package com.dexciuq.effective_mobile.presentation.screen.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.databinding.FragmentFavoritesBinding
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.presentation.screen.catalog.CatalogFragmentDirections
import com.dexciuq.effective_mobile.presentation.screen.catalog.ProductAdapter
import com.dexciuq.effective_mobile.presentation.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }
    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupFavoritesRecyclerView()
        collectData()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupFavoritesRecyclerView() {
        adapter = ProductAdapter(
            fragmentActivity = requireActivity(),
            onLikeClick = viewModel::addToFavorites,
            onUnlikeClick = viewModel::removeFromFavorites,
            onItemClick = ::navigateToDetails
        )
        binding.favorites.adapter = adapter
    }

    private fun navigateToDetails(product: Product) {
        findNavController().navigate(
            CatalogFragmentDirections.actionCatalogFragmentToProductDetailsFragment(product)
        )
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.favorites.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {}

                    is Resource.Success -> {
                        adapter.submitList(resource.data)
                    }

                    is Resource.Error -> {
                        toast(resource.throwable.message)
                    }
                }
            }
        }
    }
}