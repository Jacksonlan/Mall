package www.shop.pojo;
import lombok.Data;

@Data
public class Car {
    private Integer good_id;
    private Integer uid;
    private String current_load;
    private Integer current_count;
    private Double current_price;
    private Integer stock;
}
