package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Здесь должна быть аннотация для создания из этого класса бина firstLine.
@Component
public class FirstLine {
    //Здесь должна быть аннотация для внедрения бина secondLine
    @Autowired
    SecondLine nextLine;

    @Override
    public String toString() {
        return "Я помню чудное мгновенье:\n" + nextLine;
    }
}
