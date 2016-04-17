package com.shockn745.data;

import com.shockn745.data.jpa.JpaBlogPostRepo;
import com.shockn745.domain.application.driven.BlogPostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Kempenich Florian
 */
public class BlogPostRepositoryImplTest {

    private BlogPostRepository repository;
    @Mock
    JpaBlogPostRepo jpaRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repository = new BlogPostRepositoryImpl(jpaRepo);
    }

    @Test
    public void findAll_neverReturnsNull() throws Exception {


    }
}