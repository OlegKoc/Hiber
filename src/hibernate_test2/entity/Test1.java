package hibernate_test2.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alisa", "Kochurova", "HR", 600);
            Detail detail = new Detail("ishevsk", "81215515", "koralll79@gmail.com");

            employee.setEmpDetail(detail); // передаем детали для работника

            session.beginTransaction();  // открываем транзакци.

            session.save(employee);  //сохраняем объект в БД и detail передаем в параметр(тоже сохраняется в БД)

            session.getTransaction().commit(); // закрываем транзакцию

            System.out.println("DONE");


        } finally {
            factory.close();
        }


    }
}
