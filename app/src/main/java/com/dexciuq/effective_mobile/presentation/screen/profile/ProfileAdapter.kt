package com.dexciuq.effective_mobile.presentation.screen.profile

import com.dexciuq.effective_mobile.databinding.ItemMenuInfoBinding
import com.dexciuq.effective_mobile.databinding.ItemProfileInfoBinding
import com.dexciuq.effective_mobile.presentation.screen.profile.ProfileAdapterModel.MenuInfo
import com.dexciuq.effective_mobile.presentation.screen.profile.ProfileAdapterModel.ProfileInfo
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class ProfileAdapter(
    profileInfoOnClick: (String) -> Unit = {},
    menuInfoOnClick: (String) -> Unit = {},
) : ListDelegationAdapter<List<ProfileAdapterModel>>(
    profileInfoAdapterDelegate(profileInfoOnClick),
    menuInfoAdapterDelegate(menuInfoOnClick),
)

private fun profileInfoAdapterDelegate(
    profileInfoOnClick: (String) -> Unit = {},
) = adapterDelegateViewBinding<ProfileInfo, ProfileAdapterModel, ItemProfileInfoBinding>(
    { layoutInflater, root -> ItemProfileInfoBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.title.text = item.title
        binding.description.text = item.description
        binding.icon.setImageResource(item.icon)
        binding.endIcon.setImageResource(item.endIcon)
        binding.root.setOnClickListener { profileInfoOnClick(item.title) }
    }
}

private fun menuInfoAdapterDelegate(
    menuInfoOnClick: (String) -> Unit = {},
) = adapterDelegateViewBinding<MenuInfo, ProfileAdapterModel, ItemMenuInfoBinding>(
    { layoutInflater, root -> ItemMenuInfoBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.title.text = item.title
        binding.icon.setImageResource(item.icon)
        binding.root.setOnClickListener { menuInfoOnClick(item.title) }
    }
}