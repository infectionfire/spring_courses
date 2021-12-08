package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//sesiionfactory-фабрика по производству сессий

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //основа для работы с бд

        try {
            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc
            session.beginTransaction();//сами открываем и закрываем транзакции
//            Employee emp = session.get(Employee.class, 2);//удаление руками
//            session.delete(emp);

            session.createQuery("delete Test1 where name = 'Alex'").executeUpdate();//удаление по полю

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
