package com.dexciuq.effective_mobile.presentation.screen.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.dexciuq.effective_mobile.databinding.ActivityRegisterBinding
import com.dexciuq.effective_mobile.domain.model.User
import com.dexciuq.effective_mobile.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupTextWatchers()
        setupListeners()
        collectData()
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

//        val slots = UnderscoreDigitSlotsParser().parseSlots("+7 ___ ___-__-__")
//        val formatWatcher: FormatWatcher = MaskFormatWatcher(MaskImpl.createTerminated(slots))
//        binding.phoneLayout.editText?.let {
//            formatWatcher.installOn(it)
//        }
    }

    private fun setupListeners() {
        binding.register.setOnClickListener {
            val user = User(
                name = binding.nameLayout.editText?.text.toString(),
                surname = binding.surnameLayout.editText?.text.toString(),
                phoneNumber = binding.phoneLayout.editText?.text.toString()
            )
            viewModel.register(user)
        }
    }

    private fun isContainsOnlyCyrillic(input: String): Boolean {
        if (input.isEmpty()) return true
        return input.matches("[А-Яа-я]+".toRegex())
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewModel.isLogged.collectLatest { isLogged ->
                if (isLogged) {
                    navigateToMainActivity()
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}