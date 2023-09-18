package com.geekaca.news.controller.fore;

import com.geekaca.news.domain.News;
import com.geekaca.news.service.ConfigService;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.utils.PageResult;
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
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ConfigService configService;
    public static String theme = "amaze";

    @GetMapping({"/","/index","/index.html"})
    public String index(HttpServletRequest req) {
        return this.page(req,1);
    }

    @GetMapping("/page/{pageNum}")
    private String page(HttpServletRequest req,@PathVariable("pageNum") int pageNum){
        PageResult pageNews = newsService.getPageNews(pageNum, 8);
        req.setAttribute("blogPageResult", pageNews);
        req.setAttribute("newBlogs", 0);
        req.setAttribute("hotBlogs", 0);
        req.setAttribute("hotTags", 0);
        req.setAttribute("pageName", "首页");
        req.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/index";
    }

    //指向 新闻管理页面
    @GetMapping("/blogs")
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

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/blog/{newsId}", "/article/{newsId}"})
    public String detail(HttpServletRequest req,
                         @PathVariable("newsId") Long newsId, @RequestParam(value = "commentPage",
            required = false, defaultValue = "1") Integer commentPage) {
        /**
         * 1. 查询新闻详情，带出评论
         * 2. 更新新闻浏览量 + 1
         */
        News newsWithComments = newsService.selectById(newsId);
        req.setAttribute("blogDetailVO",newsWithComments);
        req.setAttribute("pageName", "详情");
        req.setAttribute("configurations", configService.getAllConfigs());
        int i = newsService.updateNewsViews(newsId);
        return "blog/" + theme + "/detail";
    }
}
