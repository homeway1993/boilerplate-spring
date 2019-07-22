package boilerplate.spring.mongodb.entity;

import lombok.Data;
import org.bson.Document;

import java.time.LocalDateTime;

@Data
public class PersonChangeLog {

    private String resumeToken;
    private Document change;
    private LocalDateTime createdDate;
}
