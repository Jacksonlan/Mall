package www.shop.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import www.shop.pojo.Car;
import www.shop.pojo.CarGoods;
import java.util.List;

@Mapper
public interface CarMapper {
    @Select("select  * from shoppingcar inner join goods using(good_id) where uid=#{uid} group by sid order by sid;")
    List<CarGoods> GetCar(Integer uid);
    @Delete("delete from shoppingcar where sid=#{sid}")
    Boolean RemoveCar(Integer sid);
    @Insert("insert into shoppingcar (good_id,uid,current_load,current_count,current_price,stock) values (#{good_id},#{uid},#{current_load},#{current_count},#{current_price},#{stock})")
    Boolean AddCar(Car car);
}
