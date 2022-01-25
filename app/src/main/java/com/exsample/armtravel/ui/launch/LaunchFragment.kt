package com.exsample.armtravel.ui.launch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exsample.armtravel.databinding.FragmentLaunchBinding
import com.exsample.armtravel.ui.BaseFragment
import com.exsample.armtravel.ui.base.utils.viewLifecycle
import com.exsample.armtravel.ui.HomeActivity

class LaunchFragment : BaseFragment() {
    var binding: FragmentLaunchBinding by viewLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        initApp()
        return binding.root
    }

    fun initApp() {
        startActivity(Intent(requireActivity(), HomeActivity::class.java))
        requireActivity().finish()
    }


}