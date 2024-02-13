package com.dexciuq.effective_mobile.presentation.screen.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.databinding.FragmentProfileBinding
import com.dexciuq.effective_mobile.presentation.screen.register.RegisterActivity
import com.dexciuq.effective_mobile.presentation.screen.register.RegisterViewModel
import com.dexciuq.yummy_express.common.hide
import com.dexciuq.yummy_express.common.show
import com.dexciuq.yummy_express.common.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getProfile()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupProfileInfoSection()
        collectData()
    }

    private fun setupListeners() {
        binding.logout.setOnClickListener {
            viewModel.logout()
            navigateToRegisterActivity()
        }
    }

    private fun navigateToRegisterActivity() {
        val intent = Intent(requireContext(), RegisterActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    private fun setupProfileInfoSection() {
        adapter = ProfileAdapter(
            profileInfoOnClick = {
                when (it) {
                    "Избранное" -> findNavController().navigate(R.id.action_profileFragment_to_favoritesFragment)
                }
            }
        )
        binding.profileSettings.adapter = adapter
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.profile.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        binding.progressBar.show()
                        binding.profileSettings.hide()
                    }

                    is Resource.Success -> {
                        binding.progressBar.hide()
                        binding.profileSettings.show()
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