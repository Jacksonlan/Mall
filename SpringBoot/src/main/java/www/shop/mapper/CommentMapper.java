package www.shop.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import www.shop.pojo.Comment;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comments inner join user using(uid)")
    List<Comment> GetComments();
    @Insert("insert into comments (uid,content,time) values (#{uid},#{content},#{time})")
    Boolean SendComment(Integer uid, String content,Date time);
}
