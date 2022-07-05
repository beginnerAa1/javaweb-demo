package itheima.lambda;

import lombok.Data;

import java.util.List;


@Data
public class author {

    private String name;
    private Integer age;
    private Integer id;
    private String description;
    private List<author> authors;

}
