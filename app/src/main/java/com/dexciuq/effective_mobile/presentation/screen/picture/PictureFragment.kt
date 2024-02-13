package com.dexciuq.effective_mobile.presentation.screen.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.dexciuq.effective_mobile.databinding.FragmentPictureBinding

private const val ARG_ID = "id"

class PictureFragment : Fragment() {

    private val binding by lazy { FragmentPictureBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { args ->
            binding.image.setImageResource(args.getInt(ARG_ID))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int) = PictureFragment().apply {
            arguments = bundleOf(
                ARG_ID to id,
            )
        }
    }
}