package com.geekaca.news.controller.fore;

import com.geekaca.news.domain.News;
import com.geekaca.news.service.ConfigService;
import com.geekaca.news.service.NewsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台
 */
//注解 控制器类
@Controller
@Slf4j
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ConfigService configService;

    @GetMapping({"/","/index","/index.html"})
    public String index(HttpServletRequest req) {
        return this.page(req,1);
    }

    @GetMapping("{page}/{pageNum}")
    private String page(HttpServletRequest req,@PathVariable("pageNum") int pageNum){
        newsService.getPageNews(pageNum,3);
        req.setAttribute("blogPageResult", 0);
        req.setAttribute("newBlogs", 0);

        req.setAttribute("hotBlogs", 0);

        req.setAttribute("hotTags", 0);
        req.setAttribute("pageName", "首页");
        req.setAttribute("configurations", configService.getAllConfigs());
        return "blog/"  + "/index";
    }

    //指向 新闻管理页面
    @GetMapping("blogs")
    public String List(HttpServletRequest req) {
        //为了传递值给前端页面 页面根据他来决定左侧导航菜单高亮 显示哪一个
        req.setAttribute("path","blogs");
        return "admin/blog";
    }


    //传递集合
    @RequestMapping("/all")
    public String selectAll(HttpServletRequest req){
        List<News> newsList = newsService.selectAll();
        req.setAttribute("all",newsList);
        return "newsList";
    }

    @RequestMapping("/getByName")
    public List<News> getByName(@RequestBody News news){
        return newsService.selectByName(news);
    }
    //单个值的传递
    @GetMapping("/toPage")
    public String toPage(HttpServletRequest req){
        req.setAttribute("name","Tom");
        //要用@Controller 跳转到名字为hello的页面
        return "hello";
    }
    //从控制器向页面传递对象
    @GetMapping("/newsDetail/{newsId}")
    public String toDetail(HttpServletRequest req,@PathVariable("newsId") Long newsId){
        News news = newsService.selectById(newsId);
        req.setAttribute("newsInfo",news);
        return "newsDetail";
    }

}
