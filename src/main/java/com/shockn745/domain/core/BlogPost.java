package com.shockn745.domain.core;

import java.util.Objects;

/**
 * @author Kempenich Florian
 */
public class BlogPost {

    public final String post;

    public BlogPost(String post) {
        this.post = post;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return Objects.equals(post, blogPost.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post);
    }
}
