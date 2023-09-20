package com.geekaca.news.controller.fore;

import cn.hutool.captcha.ShearCaptcha;
import com.geekaca.news.domain.News;
import com.geekaca.news.domain.NewsComment;
import com.geekaca.news.domain.TagNewsCount;
import com.geekaca.news.service.CommentService;
import com.geekaca.news.service.ConfigService;
import com.geekaca.news.service.NewsService;
import com.geekaca.news.service.TagService;
import com.geekaca.news.utils.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;

    public static String theme = "amaze";

    @GetMapping({"/","/index","/index.html"})
    public String index(HttpServletRequest req) {
        return this.page(req,1,null);
    }

    @GetMapping("/page/{pageNum}")
    private String page(HttpServletRequest req,@PathVariable("pageNum") int pageNum,
                        @RequestParam(name = "keyword", required = false) String keyword){
        if (keyword != null){
            return "blog/" + theme + "/index";
        }
        PageResult pageNews = newsService.getPageNews(pageNum, 5, keyword);
        req.setAttribute("blogPageResult", pageNews);
        //最新发布
        req.setAttribute("newBlogs", 0);
        //点击最多
        req.setAttribute("hotBlogs", 0);
        //热门标签
        List<TagNewsCount> tagCounts = tagService.getAll();
        if (tagCounts == null) {
            //创建空集合 JSON[]
            tagCounts = Collections.emptyList();
        }
        req.setAttribute("hotTags", tagCounts);
        req.setAttribute("pageName", "首页");
        req.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/index";
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword) {
        return search(request, 1,keyword);
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(HttpServletRequest req,@PathVariable("pageNum") int pageNum, @PathVariable("keyword") String keyword) {
        PageResult pageNews = newsService.getPageNews(pageNum, 5, keyword);
        req.setAttribute("blogPageResult", pageNews);
        req.setAttribute("pageName", "搜索");
        req.setAttribute("pageUrl", "search");
        req.setAttribute("keyword", keyword);
        //最新发布
        req.setAttribute("newBlogs", 0);
        //点击最多
        req.setAttribute("hotBlogs", 0);
        //热门标签
        List<TagNewsCount> tagCounts = tagService.getAll();
        if (tagCounts == null) {
            //创建空集合 JSON[]
            tagCounts = Collections.emptyList();
        }
        req.setAttribute("hotTags", tagCounts);
        req.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
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

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long newsId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String websiteUrl, @RequestParam String commentBody) {
        if (!StringUtils.hasText(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        ShearCaptcha shearCaptcha = (ShearCaptcha) session.getAttribute("verifyCode");
        if (shearCaptcha == null || !shearCaptcha.verify(verifyCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (!StringUtils.hasText(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == newsId || newsId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!StringUtils.hasText(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (!StringUtils.hasText(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (!StringUtils.hasText(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        NewsComment comment = new NewsComment();
        comment.setNewsId(newsId);
        comment.setCommentator(MyBlogUtils.cleanString(commentator));
        comment.setEmail(email);
        if (PatternUtil.isURL(websiteUrl)) {
            comment.setWebsiteUrl(websiteUrl);
        }
        comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }
}
