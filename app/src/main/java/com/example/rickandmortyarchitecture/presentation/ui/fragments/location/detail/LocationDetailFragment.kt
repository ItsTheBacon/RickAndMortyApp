package com.example.rickandmortyarchitecture.presentation.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyarchitecture.R
import com.example.rickandmortyarchitecture.base.BaseFragment
import com.example.rickandmortyarchitecture.databinding.FragmentLocationDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationDetailFragment : BaseFragment<LocationDetailViewModel, FragmentLocationDetailBinding>(
    R.layout.fragment_location_detail
) {
    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationDetailViewModel by viewModels()

}