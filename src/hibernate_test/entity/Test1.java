package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Alisa", "Kochurova", "IT", 600);
            session.beginTransaction();  // открываем транзакцию
            session.save(emp); // сохраняем объект в базу

            session.getTransaction().commit(); // закрываем транзакцию
        } finally {
            factory.close();
        }


    }
}
