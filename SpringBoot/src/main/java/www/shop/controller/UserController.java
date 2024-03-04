package www.shop.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.shop.pojo.Result;
import www.shop.pojo.User;
import www.shop.service.UserService;

@RestController
public class UserController {
    @Resource
    private UserService us;

//    用户登录
    @GetMapping("/login")
    public Result Login(String username, String password){
        return us.Login(username,password);
    }
//    添加用户信息
    @PostMapping("/addUser")
    public Result AddUser(@RequestBody User user){
        return us.AddUser(user);
    }
//    根据uid删除用户信息
    @GetMapping("/deleteUser")
    public Result DeleteUser(Integer uid){
        return us.DeleteUser(uid);
    }
}
