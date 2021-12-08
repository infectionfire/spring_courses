package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//jpa - стандартная спецификация для управления сохранением java obj в таблицу
//jpa - правила, hibernate- реализация, рекомендуется использовать аннотации jpa
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//можно не писать, если стандартным образом назван, но лучше писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        //основа для работы с бд
        Session session = null;//не будет коннекшн лика (утечки) при ексепшене
        try {
//            session = factory.getCurrentSession();//обертка для подключения базе с jdbc
//
//
//            session.beginTransaction();//сами открываем и закрываем транзакции
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit();//всегда закрываем открытую транзакцию
//            System.out.println("Done");

            session = factory.getCurrentSession();//обертка для подключения базе с jdbc


            session.beginTransaction();//сами открываем и закрываем транзакции
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);//разрушение связи
            System.out.println(detail.getEmployee());

            session.delete(detail);//удалятся детали, перед удалением убедиться, что нет ссылающихся объектов
            session.getTransaction().commit();//всегда закрываем открытую транзакцию
            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();//закроется после выполнения или не выполнения программы
        }
    }
}
