package com.tirexmurina.testapp.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.tirexmurina.testapp.BaseFragment
import com.tirexmurina.testapp.DishTestEntity
import com.tirexmurina.testapp.R
import com.tirexmurina.testapp.databinding.FragmentHomeBinding
import com.tirexmurina.testapp.presentation.adapters.BannerListAdapter
import com.tirexmurina.testapp.presentation.adapters.CategoriesListAdapter
import com.tirexmurina.testapp.presentation.adapters.MainListAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerViews()
    }

    private fun setRecyclerViews() {
        binding.testRecycler.adapter = MainListAdapter()
        binding.testRecycler.layoutManager = LinearLayoutManager(context)
        binding.bannerList.adapter = BannerListAdapter()
        binding.bannerList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesList.adapter = CategoriesListAdapter()
        binding.categoriesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.citySpinner.adapter = adapter
        }

        //binding.citySpinner.adapter =

        //todo тут временно популейтим

        val dishList = listOf(
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            ),
            DishTestEntity(
                title = "Arrabiata",
                description = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
                image = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
                price = "345"
            )
            // Repeat this pattern for 8 more elements
        )
        (binding.testRecycler.adapter as? MainListAdapter)?.contents = dishList
        val list2 = (1..15).toList()
        (binding.categoriesList.adapter as? CategoriesListAdapter)?.contents = list2
        (binding.bannerList.adapter as? BannerListAdapter)?.contents = list2

    }


}