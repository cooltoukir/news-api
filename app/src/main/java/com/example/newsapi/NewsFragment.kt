package com.example.newsapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.newsapi.viewmodels.NewsViewModel


class NewsFragment : Fragment() {

    private val newsViewModel : NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Set observer to LiveData by ViewModel object

        newsViewModel.teslaLiveData.observe(viewLifecycleOwner) {
            newsViewModel.fetchData()
            Log.d("NewsFragment", "${it.totalResults} ${it.status} ${it.articles.size}")
        }

        return inflater.inflate(R.layout.fragment_news, container, false)
    }
}
