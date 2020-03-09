package boilerplate.spring.multiplemongodb.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Inventory {

    private String id;
    private Cbu cbu;
    private String departmentCode;
    private Integer quantity;
    private List<String> inventories;
    private LocalDateTime lastInDate;

}
