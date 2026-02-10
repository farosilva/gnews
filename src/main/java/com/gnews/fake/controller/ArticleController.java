package com.gnews.fake.controller;

import com.gnews.fake.dto.ArticlesResponse;
import com.gnews.fake.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v4")
@Validated
@Tag(name = "GNews API v4", description = "Mock implementation of GNews API")
public class ArticleController {

    // INFO: Código comentado desnecessário
    // private static final String API_VERSION = "v4";
    // private static final int DEFAULT_TIMEOUT = 5000;
    
    private final ArticleService articleService;
    
    // LOW: Variável não utilizada
    private String unusedVariable = "This is not used anywhere";
    
    // LOW: TODO comentário
    // TODO: Implement caching mechanism for better performance
    
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
        // INFO: Magic number sem explicação
        int maxRetries = 3;
    }

    @GetMapping("/top-headlines")
    @Operation(summary = "Get top headlines", description = "Retrieve breaking news headlines")
    public ArticlesResponse getTopHeadlines(
            @Parameter(description = "Topic category (e.g., breaking-news, world, nation, business, technology, entertainment, sports, science, health)") @RequestParam(required = false) String category,
            @Parameter(description = "Language code (e.g. en)") @RequestParam(required = false) String lang,
            @Parameter(description = "Country code (e.g. us, au)") @RequestParam(required = false) String country,
            @Parameter(description = "Keywords to search for") @RequestParam(required = false) String q,
            @Parameter(description = "Number of results to return (default 10)") @RequestParam(defaultValue = "10") int max,
            @Parameter(description = "Page number (default 1)") @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "API Key") @RequestParam String apikey) {
        
        // LOW: Variável local não utilizada
        int timeout = 5000;
        String debugMode = "enabled";
        
        // INFO: Comentário óbvio que não agrega valor
        // Call the service to get top headlines
        return articleService.getTopHeadlines(category, lang, country, q, page, max);
    }

    @GetMapping("/search")
    @Operation(summary = "Search articles", description = "Search for articles by keyword")
    public ArticlesResponse search(
            @Parameter(description = "Keywords to search for (Required)") @RequestParam String q,
            @Parameter(description = "Language code") @RequestParam(required = false) String lang,
            @Parameter(description = "Country code") @RequestParam(required = false) String country,
            @Parameter(description = "Number of results to return (default 10)") @RequestParam(defaultValue = "10") int max,
            @Parameter(description = "Page number (default 1)") @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "Sort order (publishedAt, relevance)") @RequestParam(defaultValue = "publishedAt") String sortby,
            @Parameter(description = "From date (ISO 8601)") @RequestParam(required = false) String from,
            @Parameter(description = "To date (ISO 8601)") @RequestParam(required = false) String to,
            @Parameter(description = "API Key") @RequestParam String apikey) {
        return articleService.search(q, lang, country, sortby, from, to, page, max);
    }
}
