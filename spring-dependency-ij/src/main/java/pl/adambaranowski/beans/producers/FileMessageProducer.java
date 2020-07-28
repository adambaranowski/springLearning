package pl.adambaranowski.beans.producers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
//@Qualifier("fileMessageProducer")
//zamiast qualifier stosujemy własny
@Producer(type = Producer.ProducerType.FILE)
public class FileMessageProducer implements MessageProducer {
    @Override
    public String getMessage() {
        List<String> lines = null;
        try{
            lines = Files.readAllLines(Paths.get("message.txt"));
        }catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        if (lines!=null)
            result = lines.stream().parallel().reduce(result, (a,b) -> a+b);
        return result;
    }
}
