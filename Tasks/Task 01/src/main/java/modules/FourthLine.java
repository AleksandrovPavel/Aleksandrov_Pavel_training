package modules;

import org.springframework.stereotype.Component;

//Здесь должна быть аннотация для создания из этого класса бина fourthLone.
@Component
public class FourthLine {
    @Override
    public String toString() {
        return "Как гений чистой красоты.";
    }
}
