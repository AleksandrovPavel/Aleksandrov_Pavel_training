package org.scope.models;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Dog {

    private String message = "Woof";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(message, dog.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
