package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//sesiionfactory-фабрика по производству сессий

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //основа для работы с бд

        try {
            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc
            session.beginTransaction();//сами открываем и закрываем транзакции

            session.createQuery("update Test1 set salary=1000 " +
                    "where name='Alex'").executeUpdate();
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);//сеттер, поменяет поле

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
