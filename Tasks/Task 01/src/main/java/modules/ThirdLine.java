package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Здесь должна быть аннотация для создания из этого класса бина thirdLine.
@Component
public class ThirdLine {
    FourthLine fourthLine;

    //Здесь должна быть аннотация для внедрения бина fourthLine
    @Autowired
    public void setFourthLine(FourthLine fourthLine) {
        this.fourthLine = fourthLine;
    }

    @Override
    public String toString() {
        return "Как мимолетное виденье,\n" + fourthLine;
    }
}
