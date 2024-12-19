package com.example.trashdetection.presentation.Dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdetection.R
import com.example.trashdetection.domain.fakeData.FakeDataArtikel
import com.example.trashdetection.ui.theme.PrimaryBlue250
import com.example.trashdetection.ui.theme.PrimaryBlue400
import com.example.trashdetection.ui.theme.TextPrimary
import com.example.trashdetection.ui.theme.TrashDetectionTheme

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navigateToListArtikel: () -> Unit,
    navigateToDetailArtikel: (id: String, title: String) -> Unit
) {
    Scaffold(
        topBar = {
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
//                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                HeaderDashboard(title = "Solusi untuk Deteksi Objek Sampah. Experience Baru") {
                }
            }
            item { Spacer(modifier = Modifier.height(1.dp)) }
            item {
                Column(
                    modifier = modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Deteksi Objek",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = TextPrimary,
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_kamera),
                        contentDescription = "Kamera",
                        modifier =
                        modifier
                            .shadow(
                                elevation = 30.dp,
                                ambientColor = Color.Cyan,
                                spotColor = PrimaryBlue400
                            )
                            .clip(RoundedCornerShape(20.dp))
                            .background(PrimaryBlue250)
                            .padding(30.dp)
                            .size(70.dp),
                    )
                    Text(
                        text = "Klik dan Arahkan ke Sampah",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                        modifier = modifier.padding(15.dp),
                        color = TextPrimary
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Artikel untuk Anda",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = TextPrimary,
                    )
                    Text(
                        text = "Lihat Selengkapnya",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = TextPrimary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable { navigateToListArtikel() }
                    )
                }
            }
            val item = FakeDataArtikel.dataFake.take(3)
            items(item, key = { it.id.orEmpty() }) { article ->
                ArticleHomeItem(
                    id = article.id ?: "",
                    title = article.title ?: "",
                    content = article.content ?: "",
                    bannerUrl = article.bannerUrl ?: "",
                    modifier = Modifier
                        .clickable {
                            navigateToDetailArtikel(article.id ?: "", article.title ?: "")
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    TrashDetectionTheme {
        DashboardScreen(navigateToListArtikel = {}, navigateToDetailArtikel = { id, title -> })
    }
}