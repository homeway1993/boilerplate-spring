package boilerplate.spring.jiebaanalyzer;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestRunner implements ApplicationRunner {

    @Autowired
    private JiebaSegmenter jiebaSegmenter;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String string = "十字架18K黃金鑽石戒指";
        List<String> result = jiebaSegmenter.process(string, JiebaSegmenter.SegMode.INDEX)
                .stream()
                .map(segToken -> segToken.word)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
