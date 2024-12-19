package com.example.thrivein.ui.screen.article.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.domain.repository.ArticleRepository
import com.example.trashdetection.presentation.Artikel.ArticleItem
import com.example.trashdetection.presentation.Component.DetailTopBar
import com.example.trashdetection.ui.theme.PrimaryBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListArticleScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    navigateToDetailArticle: (id: String, title: String) -> Unit,
) {

    Scaffold(
        topBar = {
            DetailTopBar(title = stringResource(R.string.news), navigateBack = navigateBack)
        },
        containerColor = PrimaryBackground,
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val repository = ArticleRepository()
            val articles = repository.getAllArticles()

            items(articles, key = { it.id.orEmpty() }) { article ->
                ArticleItem(
                    id = article.id ?: "",
                    title = article.title ?: "",
                    content = article.content ?: "",
                    bannerUrl = article.bannerUrl ?: "",
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                        .background(PrimaryBackground)
                        .clickable {
                            navigateToDetailArticle(article.id ?: "", article.title ?: "")
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListArticleScreenPreview(
) {
    ListArticleScreen(
        modifier = Modifier,
        navigateBack = {},
        navigateToDetailArticle = { id, title -> },
    )
}