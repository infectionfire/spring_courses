package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//sesiionfactory-фабрика по производству сессий

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //основа для работы с бд

        try {
            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc

            Employee emp = new Employee("Alex", "Ivanov", "IT", 600);
            session.beginTransaction();//сами открываем и закрываем транзакции
            session.save(emp);
            //insert mysql
            session.getTransaction().commit();//всегда закрываем открытую транзакцию
            System.out.println("Done");
        }
        finally {
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
