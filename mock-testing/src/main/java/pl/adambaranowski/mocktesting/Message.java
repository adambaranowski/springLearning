package pl.adambaranowski.mocktesting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Message {

//    @Id
//    @GeneratedValue
//    private Long id;

    private boolean isCorrect;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Message() {
    }

    public Message(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
