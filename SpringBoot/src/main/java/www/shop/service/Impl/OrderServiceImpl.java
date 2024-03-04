package www.shop.service.Impl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import www.shop.mapper.OrderMapper;
import www.shop.pojo.Order;
import www.shop.pojo.OrderGoods;
import www.shop.pojo.Result;
import www.shop.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper om;
    public Result GetOrder(Integer uid){
        List<OrderGoods> o=om.GetOrder(uid);
        if(o!=null){
            return Result.success(o);
        }
        return Result.fail();
    }

    @Override
    public Result GenerateOrder(Order order) {
        Boolean od=om.GenerateOrder(order);
        if(od){
            return Result.success(order);
        }
        return Result.fail();
    }
}
