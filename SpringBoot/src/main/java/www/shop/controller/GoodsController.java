package www.shop.controller;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import www.shop.pojo.Result;
import www.shop.service.GoodsService;

@RestController
public class GoodsController {
    @Resource
    private GoodsService gs;
    @GetMapping("/getGoods")
    public Result GetGoods(){
        return gs.GetGoods();
    }
    @GetMapping("getDetail")
    public Result GetDetail(Integer good_id){
        return gs.GetDetail(good_id);
    }
}
