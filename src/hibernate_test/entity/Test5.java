package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//  в этом классе удаляем объект из БД
public class Test5 {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration() //создаем объект сессии с БД
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {


            Session session = factory.getCurrentSession(); // открываем сессию


            session.beginTransaction();  // открываем транзакцию
            Employee employee = session.get(Employee.class, 4); // получаем работника по ID
            session.delete(employee);    // удаляем работника по ID

            session.createQuery("delete Employee" + "where name 'Roman'").executeUpdate(); // удаляем работника по заданным условиям(например по имени)


            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf("Done");


        } finally {
            factory.close();
        }
    }


}
