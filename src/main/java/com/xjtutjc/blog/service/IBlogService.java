package com.xjtutjc.blog.service;


import com.xjtutjc.blog.domain.Blog;
import com.xjtutjc.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface IBlogService {

    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);



    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);

    Map<String,List<Blog>> archiveBlog();

    Blog genAndConvert(Long id);

    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Long countBlog();




}
