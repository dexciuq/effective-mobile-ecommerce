package com.dexciuq.effective_mobile.presentation.screen.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.databinding.FragmentCatalogBinding
import com.dexciuq.effective_mobile.presentation.screen.catalog.filter.Sort
import com.dexciuq.effective_mobile.presentation.screen.catalog.filter.Tag
import com.dexciuq.yummy_express.common.hide
import com.dexciuq.yummy_express.common.show
import com.dexciuq.yummy_express.common.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatalogFragment : Fragment() {

    private val binding by lazy { FragmentCatalogBinding.inflate(layoutInflater) }
    private val viewModel: CatalogViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    private var tag: Tag = Tag.ALL
    private var sort: Sort = Sort.POPULAR


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSortSection()
        setupFilterChipGroup()
        setupProductsRecyclerView()
        collectData()
    }

    private fun setupProductsRecyclerView() {
        adapter = ProductAdapter()
        adapter.registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                binding.products.scrollToPosition(0)
            }
            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                binding.products.scrollToPosition(0)
            }
            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                binding.products.scrollToPosition(0)
            }
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                binding.products.scrollToPosition(0)
            }
            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                binding.products.scrollToPosition(0)
            }
            override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                binding.products.scrollToPosition(0)
            }
        })
        binding.products.adapter = adapter
    }

    private fun setupSortSection() {
        binding.sort.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_sort, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            binding.sortText.text = item.title
            when (item.itemId) {
                R.id.sort_popular -> {
                    sort = Sort.POPULAR
                    viewModel.filter(sort, tag)
                    true
                }

                R.id.sort_price_low_to_high -> {
                    sort = Sort.LOW_TO_HIGH
                    viewModel.filter(sort, tag)
                    true
                }

                R.id.sort_price_high_to_low -> {
                    sort = Sort.HIGH_TO_LOW
                    viewModel.filter(sort, tag)
                    true
                }

                else -> false
            }
        }

        popupMenu.show()
    }

    private fun setupFilterChipGroup() {
        binding.filterGroup.check(R.id.chip_all)
        binding.filterGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isEmpty()) {
                group.check(R.id.chip_all)
                return@setOnCheckedStateChangeListener
            }

            tag = when (checkedIds.first()) {
                R.id.chip_face -> Tag.FACE
                R.id.chip_body -> Tag.BODY
                R.id.chip_suntan -> Tag.SUNTAN
                R.id.chip_mask -> Tag.MASK
                else -> Tag.ALL
            }

            viewModel.filter(sort, tag)
        }
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.products.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        binding.progressBar.show()
                        binding.products.hide()
                    }

                    is Resource.Success -> {
                        binding.products.show()
                        binding.progressBar.hide()
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