package www.shop.service.Impl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import www.shop.mapper.GoodsMapper;
import www.shop.pojo.DetailGoods;
import www.shop.pojo.Goods;
import www.shop.pojo.Result;
import www.shop.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper gm;
    @Override
    public Result GetGoods() {
        List<Goods> gs=gm.GetGoods();
        if(gs!=null){
            return Result.success(gs);
        }
        return Result.fail();
    }

    @Override
    public Result GetDetail(Integer good_id) {
        List<DetailGoods> gd=gm.GetDetail(good_id);
        if(gd!=null){
            return Result.success(gd);
        }
        return Result.fail();
    }
}
