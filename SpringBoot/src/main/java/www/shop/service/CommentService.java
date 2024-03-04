package www.shop.service;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import www.shop.pojo.Result;

import java.util.Date;

public interface CommentService {
    Result GetComments();
    Result SendComment(Integer uid, String content,Date time);
}
