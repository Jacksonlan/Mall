package www.shop.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderGoods {
    private Integer order_id;
    private Integer uid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date order_time;
    private Integer count;
    private Double price;
    private String state;
    private String introduce;
    private String business;
    private String picture;
}
