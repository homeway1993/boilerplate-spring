package boilerplate.spring.jiebaanalyzer.config;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class JiebaConfig {

    @Value("${jieba-analysis.dictionary-path}")
    private String dictionaryPath;

    @Value("${jieba-analysis.stopwords-path}")
    private String stopwordsPath;

    @Bean
    JiebaSegmenter jiebaSegmenter() {
        WordDictionary instance = WordDictionary.getInstance();
        instance.loadUserDict(Paths.get(dictionaryPath));
        return new JiebaSegmenter();
    }

    @Bean
    Set<String> stopWords() throws IOException {
        File file = new File(stopwordsPath);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Set<String> stopWords = new HashSet<>();
        while (bufferedReader.ready()) {
            stopWords.add(bufferedReader.readLine());
        }

        System.out.printf("stopWords %s load finished, total words: %s \n", stopwordsPath, stopWords.size());

        return stopWords;
    }
}
