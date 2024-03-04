package www.shop.service;
import www.shop.pojo.Address;
import www.shop.pojo.Result;

public interface AddressService {
    Result getAddressList(Integer uid);
    Result AddAddress(Address address);
    Result DeleteAddress(Integer address_id);
    Result UpdateAddress(Address address);
    Result GetDefaultAddress(Integer address_id);
    Result UpdateDefaultAddress(Integer uid,Integer default_address);
}
