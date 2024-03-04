package www.shop.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import www.shop.pojo.Order;
import www.shop.pojo.OrderGoods;

import java.util.List;

@Mapper
public interface OrderMapper {
//    获取用户订单信息
    @Select("select * from `order` inner join goods using(good_id) where uid=#{uid};")
     List<OrderGoods> GetOrder(Integer uid);
//    生成订单
    @Insert("insert into `order` (uid,good_id,order_time,count,price,state) values (#{uid},#{good_id},#{order_time},#{count},#{price},#{state})")
    Boolean GenerateOrder(Order orderGoods);
}
