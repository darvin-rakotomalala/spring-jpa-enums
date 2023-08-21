package com.poc;

import com.poc.domain.Article;
import com.poc.domain.constant.Category;
import com.poc.domain.constant.Status;
import com.poc.domain.constant.Type;
import com.poc.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class MainApplication implements ApplicationRunner {

    @Autowired
    private ArticleRepository articleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("############################   RUN   ############################");

        articleRepository.deleteAll();
        var testStatusArticle = Article.builder()
                .title("Ordinal title")
                .status(Status.OPEN)
                .build();
        articleRepository.save(testStatusArticle);

        var testTypeArticle = Article.builder()
                .title("String title")
                .type(Type.EXTERNAL)
                .build();
        articleRepository.save(testTypeArticle);

        var testCategoryArticle = Article.builder()
                .title("Converted title")
                .category(Category.MUSIC)
                .build();
        articleRepository.save(testCategoryArticle);
    }
}
