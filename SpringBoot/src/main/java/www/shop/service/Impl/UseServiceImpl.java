package www.shop.service.Impl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import www.shop.mapper.UserMapper;
import www.shop.pojo.Result;
import www.shop.pojo.User;
import www.shop.service.UserService;

@Service
public class UseServiceImpl implements UserService {
    @Resource
        private UserMapper mapper;
        public Result Login(String username, String password){
            User user=  mapper.GetUser(username);
            if(user!=null&&user.getPassword().equals(password)){
                return Result.success(user);
            }
            return Result.fail();
        }
    @Override
    public Result AddUser(User user) {
            User defined=mapper.GetUser(user.getUsername());
            if(defined==null) {
                Boolean flag = mapper.AddUser(user);
                if (flag) {
                    return Result.success(user);
                }
            }
            return Result.fail();
    }
    public Result DeleteUser(Integer uid){
            Boolean flag=mapper.DeleteUser(uid);
            if(flag){
                return Result.success(uid);
            }
            return Result.fail();
    }
}
