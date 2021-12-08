package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    //хардкодед вариант
    @Value("Преступление и наказание")
    private String name;
    @Value("Ф.М. Достоевский")
    private String author;

    @Value("1866")
    private int yearOfPublication;

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
