package www.shop.mapper;
import org.apache.ibatis.annotations.*;
import www.shop.pojo.Address;
import www.shop.pojo.Default_address;

import java.util.List;

@Mapper
public interface AddressMapper {
//    查询用户收货地址
    @Select("select * from address where uid=#{uid}")
    List<Address> GetAddressByUid(Integer uid);
//    添加收货地址
    @Insert("insert into address (uid,get_people,phone,area,detail,other) values (#{uid},#{get_people},#{phone},#{area},#{detail},#{other})")
    Boolean AddAddress(Address address);
//    删除收货地址
    @Delete("delete from address where address_id=#{address_id}")
    Boolean DeleteAddress(Integer address_id);
//    修改收货地址
    @Update("update address set get_people=#{get_people},phone=#{phone},area=#{area},detail=#{detail},other=#{other} where address_id=#{address_id}")
    Boolean UpdateAddress(Address address);
//    获取默认地址
    @Select("select * from address join user using(uid) where uid=#{uid} and default_address=address_id;")
    Default_address GetDefaultAddress(Integer uid);
//    更新默认地址
    @Update("update user set default_address=#{default_address} where uid=#{uid}")
    Boolean UpdateDefaultAddress(Integer uid,Integer default_address);
}
