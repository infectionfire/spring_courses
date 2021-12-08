package hibernate_one_to_many_bi;



import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;

//jpa - стандартная спецификация для управления сохранением java obj в таблицу
//jpa - правила, hibernate- реализация, рекомендуется использовать аннотации jpa
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        //основа для работы с бд
        Session session = null;//не будет коннекшн лика (утечки) при ексепшене
        try {

            //создание
//            session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//
//            Department dep = new Department("It", 300, 1200);
//            Employee emp1 = new Employee("Sergei", "Ivanov", 800);
//            Employee emp2 = new Employee("Semyon", "Vasiliev", 700);
//
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction();//сами открываем и закрываем транзакции
//
//            session.save(dep);
//
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");

//выборка по 1 ид
//            session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//
//
//            session.beginTransaction();//сами открываем и закрываем транзакции
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");


//********************
            session = factory.getCurrentSession();//обертка для подключения базе с jdbc


            session.beginTransaction();//сами открываем и закрываем транзакции
            Employee employee = session.get(Employee.class,2);
            session.delete(employee);

            session.getTransaction().commit();//всегда закрываем открытую транзакцию
            System.out.println("Done");


        }
        finally {
            session.close();
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
