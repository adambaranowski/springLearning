package pl.adambaranowski.springexercisedi.formatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.adambaranowski.springexercisedi.formatter.TextFormater;

@Component
@Qualifier("upperCase")
public class UpperCaseFormatter implements TextFormater {
    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}
