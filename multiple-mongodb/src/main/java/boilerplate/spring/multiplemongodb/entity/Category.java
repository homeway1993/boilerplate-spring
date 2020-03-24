package boilerplate.spring.multiplemongodb.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {

    private String id;
    private String type;
    private String code;
    private Language name;
    private Language searchDisplayName;
    private Boolean enabled;
    private LocalDateTime createDate;
}
