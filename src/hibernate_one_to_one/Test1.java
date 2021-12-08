package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//jpa - стандартная спецификация для управления сохранением java obj в таблицу
//jpa - правила, hibernate- реализация, рекомендуется использовать аннотации jpa
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        //основа для работы с бд
        Session session = null;//не будет коннекшн лика (утечки) при ексепшене
        try {
//            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//            Employee employee = new Employee("Sergei", "Ivanov", "IT", 500);
//            Detail detail = new Detail("V.Novgorod","12323124","a@a.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();//сами открываем и закрываем транзакции
//
//            session.save(employee);
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");

//            Session session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 777);
//            Detail detail = new Detail("Moscow","232132","a@1.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();//сами открываем и закрываем транзакции
//
//            session.save(employee);
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");

            session = factory.getCurrentSession();//обертка для подключения базе с jdbc

            session.beginTransaction();//сами открываем и закрываем транзакции

            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);//удалится в обоих таблицах

            session.getTransaction().commit();//всегда закрываем открытую транзакцию
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
