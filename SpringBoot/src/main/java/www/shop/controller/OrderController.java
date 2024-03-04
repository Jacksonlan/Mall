package www.shop.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import www.shop.pojo.Order;
import www.shop.pojo.OrderGoods;
import www.shop.pojo.Result;
import www.shop.service.OrderService;

@RestController
public class OrderController {
    @Resource
    private OrderService os;

//    获取用户订单信息
    @GetMapping("/getOrder")
    public Result GetOrder(Integer uid){
        return os.GetOrder(uid);
    }
//    生成订单
    @PostMapping("/generateOrder")
    public Result GenerateOrder(@RequestBody Order order){
        return os.GenerateOrder(order);
    }
}
