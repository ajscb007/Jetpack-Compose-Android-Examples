package com.mme.androidarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.data.util.Resource
import com.mme.androidarchitecture.presentation.viewmodel.NewsViewModel
import com.mme.androidarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // private val viewModel: NewsViewModel by viewModels()
    @Inject
    lateinit var factory: NewsViewModelFactory
    lateinit var viewModel: NewsViewModel
    private var country = "us"
    private var page = 1
    val articleList: MutableLiveData<List<Article>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this,factory)
            .get(NewsViewModel::class.java)

        viewNewsList()

        setContent {
            //ScrollableColumnDemo()
            LazyColumnDemo(articleList)
        }
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country,page)
        viewModel.newsHeadLines.observe(this) { response ->
            when (response) {
                is Resource.Success -> {

                    // hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG", "came here ${it.articles.toList().size}")
                        articleList.postValue(it.articles.toList())
                        // newsAdapter.differ.submitList(it.articles.toList())
                    }
                }
                is Resource.Error -> {
                    // hideProgressBar()
                    response.message?.let {
                        Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {
                    // showProgressBar()
                }

            }
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Text(
                "User Name $i",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp),
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo(articleList: MutableLiveData<List<Article>>) {

    LazyColumn {
        articleList.value?.let {
            items(it.size) {
                Text(
                    "User Name $it",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(10.dp),
                )
                Divider(color = Color.Black, thickness = 5.dp)
            }
        }
    }
}