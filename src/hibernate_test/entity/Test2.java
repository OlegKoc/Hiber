package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // открываем сессию

            Employee emp = new Employee("Sofya", "Kochurova", "PR", 700);
            session.beginTransaction();  // открываем транзакцию
            session.save(emp); // сохраняем объект в базу

            //session.getTransaction().commit();// закрываем транзакцию





            int myId = emp.getId(); //получить работника из БД
//            session = factory.getCurrentSession(); // открываем новую сессию
//            session.beginTransaction(); // открываем транзакцию
            Employee employee = session.get(Employee.class, myId); //получаем работника по ID
            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf(String.valueOf(employee));// выводим в консоль

        } finally {
            factory.close();
        }


    }
}
