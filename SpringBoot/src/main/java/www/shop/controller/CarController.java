package www.shop.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.shop.pojo.Car;
import www.shop.pojo.Result;
import www.shop.service.CarService;

@RestController
public class CarController {
    @Resource
    private CarService cs;
    @GetMapping("/getCar")
    Result GetCar(Integer uid){
        return cs.GetCar(uid);
    }
    @GetMapping("/removeCar")
    Result RemoveCar(Integer sid){
        return cs.RemoveCar(sid);
    }
    @PostMapping("/addCar")
    Result AddCar(@RequestBody Car car){
        return cs.AddCar(car);
    }
}
