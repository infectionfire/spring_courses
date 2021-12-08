package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{

    public void getBook(){
        System.out.println("Берем книгу из UniLibrary ");
        System.out.println("<----------------------------------------------->");

    }

    public String returnBook(){
        int n = 10/0;
        System.out.println("Мы возвращаем книгу в Unilibrary");
        return "Война и Мир";
    }

    public void getMagasine(){
        System.out.println("Берем журнал из Unilibrary");
        System.out.println("<----------------------------------------------->");
    }

    public void returnMagazine(){
        System.out.println("Берем возвращаем журнал Unilibrary");
        System.out.println("<----------------------------------------------->");
    }


    public void addBook(String person_name, Book book){
        System.out.println("Добавляем книгу в Uinlibrary");
        System.out.println("<----------------------------------------------->");
    }

    public void addMagazine(){
        System.out.println("Добавляем журнал  в Uinlibrary");
        System.out.println("<----------------------------------------------->");
    }
}
