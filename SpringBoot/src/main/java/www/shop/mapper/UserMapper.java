package www.shop.mapper;
import org.apache.ibatis.annotations.*;
import www.shop.pojo.User;

@Mapper
public interface UserMapper{
//    用户登录
    @Select("select * from user where username=#{username}")
        User GetUser(String username);
//    注册用户
    @Insert("insert into user (username,password) values(#{username},#{password})")
        Boolean AddUser(User user);
//    注销用户
    @Delete("delete from user where uid=#{uid}")
        Boolean DeleteUser(Integer uid);
}
