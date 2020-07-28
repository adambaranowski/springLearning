package pl.adambaranowski.beans.decorators;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseMessageDecorator implements MessageDecorator {
    @Override
    public String decorate(String message) {
        return message.toLowerCase();
    }
}
