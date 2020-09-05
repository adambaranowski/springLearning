package pl.adambaranowski.springvalidationbadwords.validator;

import pl.adambaranowski.springvalidationbadwords.common.Lang;
import pl.adambaranowski.springvalidationbadwords.constraint.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {

    private Lang[] languages;

    List<String> badWordsEn = Arrays.asList("fuck", "whore");
    List<String> badWordsPl = Arrays.asList("kurwa", "chuj", "cipa", "kutas");

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.languages=constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Lang lang: languages
             ) {
            switch (lang){
                case PL:
                    System.out.println("filtr polski");
                    return plFilter(s);
                case EN:
                    System.out.println("filtr angielski");
                    return enFilter(s);
            }
        }

        return true;
    }

    private boolean plFilter(String text){
        return generalFilter(text, badWordsPl);
    }

    private boolean enFilter(String text){
        return generalFilter(text, badWordsEn);
    }

    private boolean generalFilter(String text, List<String> badWords){
        List<String> found = badWords
                .stream()
                .filter(word -> text.toLowerCase().contains(word))
                .collect(Collectors.toList());


//        System.out.println(text.toLowerCase());
//        System.out.println(text.contains(badWordPl.get(0)));
//        System.out.println(badWordPl.get(0));
//        System.out.println("OOO");
//        System.out.println(found.toString());
//        System.out.println("OOO");
        return found.isEmpty();
    }

}
