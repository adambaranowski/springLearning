package pl.adambaranowski.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.adambaranowski.beans.producers.MessageProducer;

@Component
@Producer(type = Producer.ProducerType.SIMPLE)
@Primary
//@Qualifier("simpleMessageProducer")
public class SimpleMessageProducer implements MessageProducer {

    @Autowired
    @Qualifier("randomNumber")
    private int random;

    @Override
    public String getMessage()  {
        return "Example message " + this + " : " + random;
    }
}
