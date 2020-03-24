package boilerplate.spring.multiplemongodb.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Staging {

    private String id;
    private Map<String, List<Category>> categories;
}
