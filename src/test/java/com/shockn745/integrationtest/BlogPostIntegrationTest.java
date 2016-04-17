package com.shockn745.integrationtest;

import com.shockn745.WebAppApplication;
import com.shockn745.data.jpa.JpaBlogPostRepo;
import com.shockn745.domain.application.driving.BlogPostUseCase;
import com.shockn745.domain.application.driving.dto.BlogPostDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Kempenich Florian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebAppApplication.class)
@WebAppConfiguration
public class BlogPostIntegrationTest {


    @Autowired
    BlogPostUseCase useCase;
    @Autowired
    JpaBlogPostRepo jpaRepo; //Jpa repository is a singleton

    private String post = "Hello this is blog post";

    @Before
    public void setUp() throws Exception {
        jpaRepo.deleteAll();
    }

    @Test
    public void saveAndRetrieve_samePost() throws Exception {
        BlogPostDTO toSave = new BlogPostDTO();
        toSave.setPost(post);
        BlogPostDTO blogPostDTO = useCase.save(toSave);
        long id = blogPostDTO.getId();

        BlogPostDTO result = useCase.get(id);

        assertEquals(post, result.getPost());
        assertEquals(result, blogPostDTO);
        System.out.println(result.getPost());
    }

    @Test
    public void saveListOfPost_getAll() throws Exception {
        List<BlogPostDTO> expected = new ArrayList<>(3);
        expected.add(BlogPostDTO.make("first"));
        expected.add(BlogPostDTO.make("second"));
        expected.add(BlogPostDTO.make("third"));

        for (BlogPostDTO postDTO : expected) {
            useCase.save(postDTO);
        }

        List<BlogPostDTO> result = useCase.getAll();

        assertEquals(3, result.size());
        for (int i = 0; i < 3; i++) {
            String expectedPost = expected.get(i).getPost();
            String resultPost = result.get(i).getPost();
            assertEquals(expectedPost, resultPost);
        }
    }
}
