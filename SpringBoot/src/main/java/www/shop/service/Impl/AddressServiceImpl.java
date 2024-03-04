package www.shop.service.Impl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import www.shop.mapper.AddressMapper;
import www.shop.pojo.Address;
import www.shop.pojo.Default_address;
import www.shop.pojo.Result;
import www.shop.service.AddressService;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Resource
    private AddressMapper am;
//    实现获取收货地址接口
    public Result getAddressList(Integer uid){
        List<Address> address=am.GetAddressByUid(uid);
        return Result.success(address);
    }
//    实现添加收货地址接口
    @Override
    public Result AddAddress(Address address) {
        Boolean aa=am.AddAddress(address);
        if(aa){
            return Result.success(address);
        }
        return Result.fail();
    }
//    实现删除收货地址接口
    @Override
    public Result DeleteAddress(Integer address_id) {
        Boolean da=am.DeleteAddress(address_id);
        if(da){
            return Result.success(address_id);
        }
        return Result.fail();
    }
//    实现修改收货地址接口
    @Override
    public Result UpdateAddress(Address address) {
        Boolean ua=am.UpdateAddress(address);
        if(ua){
            return Result.success(address);
        }
        return Result.fail();
    }
//    实现获取默认地址接口
    @Override
    public Result GetDefaultAddress(Integer uid) {
        Default_address gda=am.GetDefaultAddress(uid);
        if(gda!=null){
            return Result.success(gda);
        }
        return Result.fail();
    }
//    实现修改默认地址接口
    @Override
    public Result UpdateDefaultAddress(Integer uid, Integer default_address) {
        Boolean uda=am.UpdateDefaultAddress(uid, default_address);
        if(uda){
            return Result.success(true);
        }
        return Result.fail();
    }
}
