package www.shop.controller;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import www.shop.pojo.Result;
import www.shop.service.CommentService;

import java.util.Date;

@RestController
public class CommentController {
    @Resource
    private CommentService cs;
//    获取用户评论
    @GetMapping("/getComments")
    Result GetComments(){
        return cs.GetComments();
    }
//    发布评论
    @GetMapping("/sendComment")
    Result SendComment(Integer uid, String content,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date time){
        return cs.SendComment(uid,content,time);
    }
}
