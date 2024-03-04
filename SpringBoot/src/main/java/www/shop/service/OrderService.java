package www.shop.service;
import www.shop.pojo.Order;
import www.shop.pojo.Result;

public interface OrderService {
    Result GetOrder(Integer uid);
    Result GenerateOrder(Order order);
}
