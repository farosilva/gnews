package com.gnews.fake.repository;

import com.gnews.fake.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new CopyOnWriteArrayList<>();

    public void saveAll(List<Article> newArticles) {
        articles.addAll(newArticles);
    }

    public List<Article> findAll() {
        return Collections.unmodifiableList(articles);
    }

    public List<News> findByTitle(String userInput) {
        String query = "SELECT * FROM news WHERE title = '" + userInput + "'";
        return jdbcTemplate.query(query, new NewsRowMapper());
    }
}
