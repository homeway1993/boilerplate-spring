package boilerplate.spring.mongodb.service;

import boilerplate.spring.mongodb.entity.PersonChangeLog;
import boilerplate.spring.mongodb.repository.PersonChangeLogRepository;
import boilerplate.spring.mongodb.repository.PersonRepository;
import com.mongodb.client.ChangeStreamIterable;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PersonChangeLogServiceImpl implements PersonChangeLogService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonChangeLogRepository personChangeLogRepository;

    @Autowired
    private PersonChangeStreamProcessor personChangeStreamProcessor;

    @Override
    public void process() {
        PersonChangeLog personChangeLog = personChangeLogRepository.findFirstByOrderByCreatedDateDesc();
        ChangeStreamIterable<Document> watch = personRepository.watch();

        if (personChangeLog != null) {
            watch.resumeAfter(new BsonDocument("_data", new BsonString(personChangeLog.getResumeToken())));
            log.info("watch by resume token: {}", personChangeLog.getResumeToken());
        }

        watch.forEach(personChangeStreamProcessor);
    }
}
