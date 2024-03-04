package www.shop.service;
import www.shop.pojo.Result;
import www.shop.pojo.User;


public interface UserService{
    Result Login(String username, String password);

    Result AddUser(User user);

    Result DeleteUser(Integer uid);
}
