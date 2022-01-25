package com.exsample.armtravel.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exsample.armtravel.databinding.FragmentFavoriteBinding
import com.exsample.armtravel.ui.BaseFragment
import com.exsample.armtravel.ui.base.utils.viewLifecycle


class FavoriteFragment : BaseFragment() {

    private var binding: FragmentFavoriteBinding by viewLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            fragmentFavorite = this@FavoriteFragment
        }
        return binding.root
    }

}