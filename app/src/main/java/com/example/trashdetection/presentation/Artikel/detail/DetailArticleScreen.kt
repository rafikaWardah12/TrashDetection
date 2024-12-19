package com.example.thrivein.ui.screen.article.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.trashdetection.R
import com.example.trashdetection.domain.repository.ArticleRepository
import com.example.trashdetection.presentation.Component.DetailTopBar
import com.example.trashdetection.ui.theme.PrimaryBackground
import com.example.trashdetection.ui.theme.PrimaryBlue200
import com.example.trashdetection.ui.theme.PrimaryBlue250

@Composable
fun DetailArticleScreen(
    modifier: Modifier = Modifier,
    id: String,
    title: String,
    navigateBack: () -> Unit,
) {
    val repository = ArticleRepository()
    val article = remember(id) { repository.getArticleById(id) }

    Scaffold(
        topBar = {
            DetailTopBar(title = title, navigateBack = navigateBack)
        },
    ) { innerpadding ->
        val scrollState = rememberScrollState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = PrimaryBackground
        ) {

            if (article != null) {

                Box(
                    modifier = modifier
                        .background(PrimaryBackground)
                        .padding(innerpadding)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp)
                                .graphicsLayer {
                                    alpha =
                                        1f - (scrollState.value.toFloat() / scrollState.maxValue / 2)
                                    translationY = 0.5f * scrollState.value
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(400.dp),
                                model = article.bannerUrl ?: "",
                                contentDescription = title,
                                contentScale = ContentScale.Crop,
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
                            colors = CardDefaults.cardColors(containerColor = Color.White)

                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 20.dp)
                            ) {
                                Text(
                                    text = article.title ?: "",
                                    style = MaterialTheme.typography.headlineMedium.copy(

                                    )
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_profile),
                                            contentDescription = null
                                        )
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            text = article.author ?: "",
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.Normal
                                            )
                                        )

                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                    ) {
                                        Spacer(modifier = Modifier.width(40.dp))
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_tanggal),
                                            contentDescription = null
                                        )
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            text = article.date,
                                            style = MaterialTheme.typography.labelMedium.copy(
                                                fontWeight = FontWeight.Normal
                                            )
                                        )
                                    }
                                }
                                Text(
                                    modifier = Modifier.padding(
                                        top = 10.dp, bottom = 40.dp
                                    ),
                                    text = article.content ?: "",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontWeight = FontWeight.Normal
                                    ),
                                    textAlign = TextAlign.Justify,
                                    overflow = TextOverflow.Visible,
                                )
                            }
                        }

                    }
                }
            } else {
                Text(text = "Data Tidak Ditemukan")
            }
        }
    }
}


@Preview
@Composable
fun DetailArticleScreenPreview() {
    DetailArticleScreen(
        modifier = Modifier,
        id = "1",
        title = "Detail",
        navigateBack = {},
    )
}