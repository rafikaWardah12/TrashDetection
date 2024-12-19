package com.example.trashdetection.domain.repository

import com.example.trashdetection.domain.fakeData.FakeDataArtikel.dataFake
import com.example.trashdetection.domain.model.ArtikelModul

class ArticleRepository {
    fun getArticleById(articleId: String): ArtikelModul? {
        return dataFake.find { it.id == articleId }
    }

    fun getAllArticles(): List<ArtikelModul> {
        return dataFake
    }
}