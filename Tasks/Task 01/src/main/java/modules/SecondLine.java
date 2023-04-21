package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Здесь должна быть аннотация для создания из этого класса бина secondLine.
@Component
public class SecondLine {
    ThirdLine thirdLine;

    //Здесь должна быть аннотация для внедрения бина thirdLine
    @Autowired
    public SecondLine(ThirdLine thirdLine) {
        this.thirdLine = thirdLine;
    }

    @Override
    public String toString() {
        return "Передо мной явилась ты,\n" + thirdLine;
    }
}
