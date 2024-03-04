package www.shop.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.shop.pojo.Address;
import www.shop.pojo.Result;
import www.shop.service.AddressService;

@RestController
public class AddressController {
    @Resource
    private AddressService as;

//    获取用户收货地址信息
    @GetMapping("/getAddress")
    Result getAddressList(Integer uid) {
        return as.getAddressList(uid);
    }
//    添加收货地址
    @PostMapping("/addAddress")
    Result addAddress(@RequestBody  Address address){
        return as.AddAddress(address);
    }
//    删除收货地址
    @GetMapping("/deleteAddress")
    Result deleteAddress(Integer address_id){
        return as.DeleteAddress(address_id);
    }
//    更新收货地址
    @PostMapping("/updateAddress")
    Result updateAddress(@RequestBody Address address){
        return as.UpdateAddress(address);
    }
//    获取默认地址
    @GetMapping("/getDefaultAddress")
    Result getDefaultAddress(Integer uid){
        return as.GetDefaultAddress(uid);
    }
//    变更默认地址
    @GetMapping("/updateDefaultAddress")
    Result UpdateDefaultAddress(Integer uid,Integer default_address){
        return as.UpdateDefaultAddress(uid, default_address);
    }
}
