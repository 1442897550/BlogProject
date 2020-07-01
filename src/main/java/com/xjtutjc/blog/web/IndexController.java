package com.xjtutjc.blog.web;


import com.xjtutjc.blog.NotFoundException;
import com.xjtutjc.blog.service.IBlogService;
import com.xjtutjc.blog.service.ITagService;
import com.xjtutjc.blog.service.ITypeService;
import com.xjtutjc.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ITagService tagService;
    @GetMapping("/")
    public String index(@PageableDefault(size = 5, sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));

        return "index";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 5, sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String query, Model model){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.genAndConvert(id));

        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}