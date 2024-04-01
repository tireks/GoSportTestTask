package com.tirexmurina.testapp.presentation.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tirexmurina.testapp.BaseFragment
import com.tirexmurina.testapp.R
import com.tirexmurina.testapp.databinding.FragmentHomeBinding
import com.tirexmurina.testapp.domain.entity.Category
import com.tirexmurina.testapp.domain.entity.Dish
import com.tirexmurina.testapp.presentation.HomeViewModel
import com.tirexmurina.testapp.presentation.HomeViewState
import com.tirexmurina.testapp.presentation.adapters.BannerListAdapter
import com.tirexmurina.testapp.presentation.adapters.CategoriesListAdapter
import com.tirexmurina.testapp.presentation.adapters.MainListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel : HomeViewModel by viewModels()
    //создание экземпляра ViewModel с помощью viewModels() из библиотеки Lifecycle Kotlin.

    override fun inflateViewBinding(
        //популэйтим макет и получаем экземпляр биндинга,
        // наследование от BaseFragment в этом фрагменте исключительно чтобы избавиться от бойлерплэйта
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, ::handleState) // подписались на LiveData и задали функцию-хэндлер
        setRecyclerViews() //настройка RecyclerView
        loadStartData() //загружаем первоначальные данные
    }

    //метод для обработки различных состояний (например, загрузка данных, показ ошибок, отображение контента).
    private fun handleState(homeViewState: HomeViewState) {
        when(homeViewState){
            is HomeViewState.Initial -> Unit
            is HomeViewState.Content -> showContent(
                homeViewState.dishes,
                homeViewState.categories,
                homeViewState.activeCategory
            )
            is HomeViewState.Error -> showError(homeViewState.errorMsg)
            is HomeViewState.Loading -> showLoading()
            else -> {} //студия чудит, иногда требует этот else, хотя он не нужен
        }
    }

    private fun loadStartData() {
        viewModel.getData()
    }

    private fun showLoading() {
        with(binding) {
            //переключение между показываемыми элементами
            errorContent.isVisible = false
            mainDataContainer.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun showError(errorMsg: String) {
        Log.d("AAA", errorMsg)
        with(binding) {
            //переключение между показываемыми элементами
            progressBar.isVisible = false
            mainDataContainer.isVisible = false
            errorContent.isVisible = true
            //отображаем инфо об ошибке
            errorText.text = errorMsg
            errorButton.setOnClickListener {
                loadStartData()
            }
        }
    }

    private fun showContent(
        dishes: List<Dish>,
        categories: List<Category>,
        activeCategory: Category
    ) {
        with(binding){
            //переключение между показываемыми элементами
            progressBar.isVisible = false
            errorContent.isVisible = false
            mainDataContainer.isVisible = true
            //передаем в адаптер список Dish для работы с ним
            (binding.mainList.adapter as? MainListAdapter)?.contents = dishes

            // тут контроллируем активную Category
            // если в ней имя пустое (то есть просто плэйсхолдер), это значит активная не выбрана,
            // передаем просто список Category как пришел, адаптеру сообщеаем activeCategory = null
            if (activeCategory.name.isEmpty()){
                (binding.categoriesList.adapter as? CategoriesListAdapter)?.activeCategory = null
                (binding.categoriesList.adapter as? CategoriesListAdapter)?.contents = categories
            } else {
                // а сюда переходим если активная выбрана, в таком случае нужно пересоздать список Category,
                // чтобы активную в нем поставить на первое место и этот пересозданный список уже передаем в адаптер,
                // ну и саму активную тоже передаем
                (binding.categoriesList.adapter as? CategoriesListAdapter)?.activeCategory = activeCategory
                val categoriesModified : List<Category> = mutableListOf<Category>().apply {
                    add(activeCategory)
                    categories.forEach {category ->
                        if (category != activeCategory) {
                            add(category)
                        }
                    }
                }
                (binding.categoriesList.adapter as? CategoriesListAdapter)?.contents = categoriesModified
            }

            val imageList = listOf(
                R.drawable.pic_bannerpizza1,
                R.drawable.pic_bannerpizza2,
                R.drawable.pic_bannerpizza3
                //это исключительно в рамках хардкода картинок
            )
            //передаем список картинок
            (binding.bannerList.adapter as? BannerListAdapter)?.contents = imageList
        }
    }

    //метод для настройки RecyclerView для списка Dish, баннеров и Category.
    private fun setRecyclerViews() {
        binding.mainList.adapter = MainListAdapter()
        binding.mainList.layoutManager = LinearLayoutManager(context)
        binding.bannerList.adapter = BannerListAdapter()
        binding.bannerList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesList.adapter = CategoriesListAdapter(::handleCategoryChoice, ::handleCategoryClear)
        binding.categoriesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //создание адаптера для Spinner'а и установки его в Spinner.
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.citySpinner.adapter = adapter
        }

    }

    private fun handleCategoryClear() {
        viewModel.restartData()
    }

    private fun handleCategoryChoice(category: Category) {
        viewModel.getDishesByCategory(category)
    }


}