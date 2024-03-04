package www.shop.pojo;
import lombok.Data;

@Data
public class CarGoods {
    private Integer sid;
    private String picture;
    private String introduce;
    private String current_load;
    private Integer current_count;
    private Double current_price;
    private Integer stock;
    private Boolean select;
}
