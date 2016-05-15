package com.shockn745;

import com.shockn745.domain.application.driven.MarkdownParser;
import com.shockn745.domain.application.mapper.BlogPostMapper;
import com.shockn745.domain.core.BlogPostFactory;
import com.shockn745.domain.core.PagesManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kempenich Florian
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public BlogPostMapper getBlogPostMapper(MarkdownParser parser) {
        BlogPostFactory blogPostFactory = new BlogPostFactory(parser);
        return new BlogPostMapper(blogPostFactory);
    }

    @Bean
    public PagesManagerFactory getPagesManagerFactory(@Qualifier("posts-per-page") int postsPerPage) {
        return new PagesManagerFactory(postsPerPage);
    }

    @Bean
    @Qualifier(value = "posts-per-page")
    public int getPostsPerPage() {
        return 2;
    }

}