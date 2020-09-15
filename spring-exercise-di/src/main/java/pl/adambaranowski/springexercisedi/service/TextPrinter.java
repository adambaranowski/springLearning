package pl.adambaranowski.springexercisedi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.adambaranowski.springexercisedi.formatter.TextFormater;

@Component
public class TextPrinter {
    private TextFormater formatter;

    @Autowired
    public TextPrinter(@Qualifier("upperCase") TextFormater formatter) {
        this.formatter = formatter;
    }

    public void println(String text){
        System.out.println(formatter.format(text));
    }

    public void print(String string){
        System.out.print(formatter.format(string));
    }
}
