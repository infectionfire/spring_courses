package hibernate_one_to_many_unidirectional;




import hibernate_one_to_many_unidirectional.entity.Department;
import hibernate_one_to_many_unidirectional.entity.Employee;
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
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        //основа для работы с бд
        Session session = null;//не будет коннекшн лика (утечки) при ексепшене
        try {
//********************

//            //создание
//            session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//
//            Department dep = new Department("Sales", 500, 1500);
//            Employee emp1 = new Employee("Sergei", "Ivanov", 800);
//            Employee emp2 = new Employee("Georgij", "Sidorov", 1500);
//            Employee emp3 = new Employee("Anton", "Petrov", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.beginTransaction();//сами открываем и закрываем транзакции
//
//            session.save(dep);
//
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");
//********************

//выборка по 1 ид
            session = factory.getCurrentSession();//обертка для подключения базе с jdbc


            session.beginTransaction();//сами открываем и закрываем транзакции
            System.out.println("Get department");
            Department department = session.get(Department.class,1);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());


            session.getTransaction().commit();//всегда закрываем открытую транзакцию
            System.out.println("Done");


//********************
//            session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//
//
//            session.beginTransaction();//сами открываем и закрываем транзакции
//            Employee employee = session.get(Employee.class,2);
//            session.delete(employee);
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");


        }
        finally {
            session.close();
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
