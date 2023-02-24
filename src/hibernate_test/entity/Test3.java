package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
// в этом классе получаем всех работников из БД и по заданным условиям

public class Test3 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // открываем сессию

            session.beginTransaction();  // открываем транзакцию
//            List<Employee> emps = session.createQuery("from Employee").getResultList();// получаем всех работников из БД
//            for (Employee e : emps) {
//                System.out.println(e);
//
//            }
            List<Employee> emps = session.createQuery
                    ("from Employee " + "where name = 'Roman' AND salary>500").getResultList();// получаем работника из БД по заданным условиям
            for (Employee emp : emps) {
                System.out.println(emp);
            }

            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf("Done");


        } finally {
            factory.close();
        }


    }
}
