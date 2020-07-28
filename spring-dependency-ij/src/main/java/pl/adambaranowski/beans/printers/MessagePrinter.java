package pl.adambaranowski.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.adambaranowski.beans.decorators.MessageDecorator;
import pl.adambaranowski.beans.producers.MessageProducer;
import pl.adambaranowski.beans.producers.Producer;

@Component
public class MessagePrinter {

    //Można wstrzykiwać bezpośrednio nad polem
    //@Autowired
    private MessageProducer producer;

    private MessageDecorator decorator;

    MessagePrinter() {}

    //przez konstruktor wstrzykujemy zależności wymagane
    @Autowired
//    public MessagePrinter(@Qualifier("simpleMessageProducer") MessageProducer producer) {
//        this.producer = producer;
//    }
    public MessagePrinter(@Producer(type = Producer.ProducerType.SIMPLE) MessageProducer producer) {
        this.producer = producer;
    }

    public MessageProducer getProducer() {
        return producer;
    }

    //przez setter wstrzykujemy zależności opcjonalne
    //@Autowired
    public void setProducer(MessageProducer producer) {
        this.producer = producer;
    }

    @Autowired(required = false)
    public void setDecorator(MessageDecorator decorator) {
        this.decorator = decorator;
    }

    public void print() {
        String message = producer.getMessage();
        message = decorator!=null? decorator.decorate(message) : message;
        System.out.println(message);
    }
}
