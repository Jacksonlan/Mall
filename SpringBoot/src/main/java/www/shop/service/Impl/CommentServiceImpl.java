package www.shop.service.Impl;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import www.shop.mapper.CommentMapper;
import www.shop.pojo.Comment;
import www.shop.pojo.Result;
import www.shop.service.CommentService;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper cm;
    @Override
    public Result GetComments() {
        List<Comment> gc=cm.GetComments();
        if(gc!=null){
            return Result.success(gc);
        }
        return Result.fail();
    }
    @Override
    public Result SendComment(Integer uid, String content,Date time) {
        Boolean sc=cm.SendComment(uid,content,time);
        if(sc){
            return Result.success(true);
        }
        return Result.fail();
    }
}
