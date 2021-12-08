package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {


        //указываем класс, который является конфигурационным
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

//        Pet cat1 = context.getBean("catBean", Pet.class);
//        Pet cat2 = context.getBean("catBean", Pet.class);
        Person person = context.getBean("personBean", Person.class);
        Person person2 = context.getBean("personBean", Person.class);
//        person.callYourPet();
//        person.callYourPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurname());

        context.close();
    }
}
