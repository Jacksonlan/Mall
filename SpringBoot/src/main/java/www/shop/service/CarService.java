package www.shop.service;
import www.shop.pojo.Car;
import www.shop.pojo.Result;

public interface CarService {
    Result GetCar(Integer uid);
    Result RemoveCar(Integer sid);
    Result AddCar(Car car);
}
