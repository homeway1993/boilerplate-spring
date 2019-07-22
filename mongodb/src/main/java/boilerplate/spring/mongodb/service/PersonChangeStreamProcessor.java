package boilerplate.spring.mongodb.service;

import boilerplate.spring.mongodb.entity.PersonChangeLog;
import boilerplate.spring.mongodb.repository.PersonChangeLogRepository;
import com.mongodb.Block;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class PersonChangeStreamProcessor implements Block<ChangeStreamDocument<Document>> {

    @Autowired
    private PersonChangeLogRepository personChangeLogRepository;

    @Override
    public void apply(ChangeStreamDocument<Document> document) {
        log.info("Received a ChangeStream Document: {}", document);

        PersonChangeLog personChangeLog = new PersonChangeLog();
        personChangeLog.setResumeToken(document.getResumeToken().getString("_data").getValue());
        personChangeLog.setChange(document.getFullDocument());
        personChangeLog.setCreatedDate(LocalDateTime.now());

        personChangeLogRepository.insert(personChangeLog);
    }
}
