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
        Session session = null;

        try {
             session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Kochurov", "Sales", 1000);
//            Detail detail = new Detail("ishevsk", "8121545216", "koralll18@gmail.com");
//
//            employee.setEmpDetail(detail); // передаем детали для работника  с помощью сеттера
//
//            session.beginTransaction();  // открываем транзакци.
//
//            session.save(employee);  //сохраняем объект в БД и detail передаем в параметр(тоже сохраняется в БД)
//
//            session.getTransaction().commit(); // закрываем транзакцию
//
//            System.out.println("DONE");


//            session.beginTransaction();  // открываем транзакци.
//            Employee emp = session.get(Employee.class, 1); // получаем детали работника по ID
//            System.out.println(emp.getEmpDetail());
//
//
//            session.getTransaction().commit(); // закрываем транзакцию
//
//            System.out.println("DONE");


            session.beginTransaction();  // открываем транзакци.
            Employee emp = session.get(Employee.class, 2); // получаем детали работника по ID и сохраняем в emp
            session.delete(emp);  //  удаляем emp



            session.getTransaction().commit(); // закрываем транзакцию

            System.out.println("DONE");


        } finally {
            session.close();
            factory.close();
        }


    }
}
