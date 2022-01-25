package com.exsample.armtravel.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.exsample.armtravel.databinding.FragmentPlaceBinding
import com.exsample.armtravel.proxy.place.PlaceItemDto
import com.exsample.armtravel.ui.BaseFragment
import com.exsample.armtravel.ui.base.utils.navigateSafe
import com.exsample.armtravel.ui.base.utils.viewLifecycle
import java.util.ArrayList

class PlaceFragment : BaseFragment() {

    private var binding: FragmentPlaceBinding by viewLifecycle()
    private lateinit var placeAdapter: PlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        placeAdapter = PlaceAdapter { item ->
            onPlaceItemClicked(item)
        }
       placeAdapter.updateData( testPlaces())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaceBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            fragmentPlace = this@PlaceFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun onPlaceItemClicked(item: PlaceItemDto) {
//        findNavController().navigateSafe(PlaceFragmentDirections.actionGlobalPlaceDetailsFragment(item))
    }
    private fun setupViews() {
        with(binding) {
            placeRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            placeRecyclerView.adapter = placeAdapter
        }
    }


   private  fun testPlaces():List<PlaceItemDto>{

       val testPlaces = mutableListOf<PlaceItemDto>()
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
       testPlaces.add( PlaceItemDto("title","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Filendapp%2F&psig=AOvVaw29VJjfLYI2lyzAa142NNkS&ust=1643215936955000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCevsOuzfUCFQAAAAAdAAAAABAJ"))
return testPlaces

   }

}