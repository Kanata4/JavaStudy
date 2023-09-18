package com.geekaca.news.controller.admin;


import com.geekaca.news.service.CommentService;
import com.geekaca.news.utils.PageBean;
import com.geekaca.news.utils.Result;
import com.geekaca.news.utils.ResultGenerator;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/admin")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/comments/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        Object page = params.get("page");
        Object limit = params.get("limit");
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        //string -> Integer
        PageBean pageBean = new PageBean();
        int intPageNo = Integer.parseInt(page.toString());
        int intLimit = Integer.parseInt(limit.toString());
        int start = (intPageNo - 1) * intLimit;
        pageBean.setPageNo(start);
        pageBean.setPageSize(intLimit);

        return ResultGenerator.genSuccessResult(commentService.getCommentsPage(pageBean));
    }

    /**
     * 审核 评论
     * @param ids  多条评论的id
     * @return
     */
    @PostMapping("/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (commentService.checkDone(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("审核失败");
        }
    }
//
//    @PostMapping("/comments/reply")
//    @ResponseBody
//    public Result checkDone(@RequestParam("commentId") Long commentId,
//                            @RequestParam("replyBody") String replyBody) {
//        if (commentId == null || commentId < 1 || !StringUtils.hasText(replyBody)) {
//            return ResultGenerator.genFailResult("参数异常！");
//        }
//        if (commentService.reply(commentId, replyBody)) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("回复失败");
//        }
//    }
//
   @PostMapping("/comments/delete")
   @ResponseBody
   public Result delete(@RequestBody Integer[] ids) {
        for(int i=0 ;i< 99;i++){
            System.out.println(i);
            System.out.println(i);
            System.out.println(i);
            System.out.println(i); 
            System.out.println(i);
        }
        return ResultGenerator.genSuccessResult();
   }
//
    @GetMapping("/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }


}
