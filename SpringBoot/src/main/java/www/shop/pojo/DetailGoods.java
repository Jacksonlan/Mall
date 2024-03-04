package www.shop.pojo;
import lombok.Data;

@Data
public class DetailGoods {
    private Integer good_id;
    private String introduce;
    private String picture;
    private String business;
    private String load;
    private Double price;
    private Integer sell;
    private Integer stock;
}
