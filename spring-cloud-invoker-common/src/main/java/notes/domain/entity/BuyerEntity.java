package notes.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/4/8 22:14
 */
@Data
public class BuyerEntity {
    private Long id;

    private Long venderId;

    private Integer age;

    private String name;

    private String username;

    private String password;

    private Date birthday;
}
