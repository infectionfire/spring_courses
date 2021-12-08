package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//sesiionfactory-фабрика по производству сессий

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //основа для работы с бд

        try {
            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc
            session.beginTransaction();//сами открываем и закрываем транзакции

//            List<Employee> emps = session.createQuery("from Employee")//пишем имя класса
//                            .getResultList();//работаем с java code

            List<Employee> emps = session.createQuery("from Test1 " +
                            "where name = 'Alex' AND salary>1650")//пишем имя класса
                            .getResultList();//работаем с java code

            for (Employee e: emps){
                System.out.println(e);
            }


            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
