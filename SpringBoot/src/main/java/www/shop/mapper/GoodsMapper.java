package www.shop.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import www.shop.pojo.DetailGoods;
import www.shop.pojo.Goods;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select picture,introduce,good_id,min(price) as lower_price from goods group by good_id")
    List<Goods> GetGoods();
    @Select("select *  from goods where good_id=#{good_id};")
    List<DetailGoods> GetDetail(Integer good_id);
}
