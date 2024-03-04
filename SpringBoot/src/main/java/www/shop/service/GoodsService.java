package www.shop.service;

import www.shop.pojo.Goods;
import www.shop.pojo.Result;

public interface GoodsService {
    Result GetGoods();
    Result GetDetail(Integer good_id);
}
