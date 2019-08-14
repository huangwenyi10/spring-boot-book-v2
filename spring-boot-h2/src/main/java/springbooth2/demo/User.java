package springbooth2.demo;

import lombok.Data;

import javax.persistence.*;

/**
 * 描述：用户实体
 * @author ay
 * @date 2019-03-13
 */
@Entity
@Table(name = "ay_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
}
