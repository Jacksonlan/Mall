package www.shop.service.Impl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import www.shop.mapper.CarMapper;
import www.shop.pojo.Car;
import www.shop.pojo.CarGoods;
import www.shop.pojo.Result;
import www.shop.service.CarService;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper cm;
    public Result GetCar(Integer uid){
        List<CarGoods> gc=cm.GetCar(uid);
        if (gc!=null){
            return Result.success(gc);
        }else {
            return Result.fail();
        }
    }
    public Result RemoveCar(Integer sid){
        Boolean rc=cm.RemoveCar(sid);
        if(rc){
            return Result.success(sid);
        }
        return Result.fail();
    }
    public Result AddCar(Car car){
        Boolean ad=cm.AddCar(car);
        if(ad){
            return Result.success(car);
        }
        return Result.fail();
    }
}
