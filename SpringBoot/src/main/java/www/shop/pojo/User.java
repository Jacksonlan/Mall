package www.shop.pojo;
import lombok.Data;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String default_address;
}
