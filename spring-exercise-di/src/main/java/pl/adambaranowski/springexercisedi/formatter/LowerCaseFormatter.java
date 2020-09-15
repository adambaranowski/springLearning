package pl.adambaranowski.springexercisedi.formatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.adambaranowski.springexercisedi.formatter.TextFormater;

@Component
@Qualifier("lowerCase")
public class LowerCaseFormatter implements TextFormater {
    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
}
