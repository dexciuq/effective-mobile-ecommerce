package com.dexciuq.effective_mobile.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private val binding by lazy { FragmentRegisterBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTextWatchers()
        setupListeners()
    }

    private fun setupTextWatchers() {
        binding.nameLayout.editText?.addTextChangedListener {
            if (isContainsOnlyCyrillic(it.toString())) {
                binding.nameLayout.isErrorEnabled = false
                binding.nameLayout.error = null
            } else {
                binding.nameLayout.isErrorEnabled = true
                binding.nameLayout.error = "Поля должна содержать только буквы кириллицы"
            }
        }

        binding.surnameLayout.editText?.addTextChangedListener {
            if (isContainsOnlyCyrillic(it.toString())) {
                binding.surnameLayout.isErrorEnabled = false
                binding.surnameLayout.error = null
            } else {
                binding.surnameLayout.isErrorEnabled = true
                binding.surnameLayout.error = "Поля должна содержать только буквы кириллицы"
            }
        }

        binding.phoneLayout.editText?.addTextChangedListener {

        }
    }

    private fun setupListeners() {
        binding.register.setOnClickListener {
            val navController = findNavController()
            navController.navigate(
                R.id.nav_graph_home, null,
                NavOptions.Builder().setPopUpTo(R.id.nav_graph_auth, true).build()
            )
        }
    }

    private fun isContainsOnlyCyrillic(input: String): Boolean {
        if (input.isEmpty()) return true
        return input.matches("[А-Яа-я]+".toRegex())
    }
}