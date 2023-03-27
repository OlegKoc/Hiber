package hibernate_test2.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Sofya", "Kochurova", "HR", 950);       // добавляем работника в БД
//            Detail detail = new Detail("Izhevsk", "455486991", "Sofya79@gmail.com");
//
//            employee.setEmpDetail(detail); // передаем детали для работника  с помощью сеттера
//            detail.setEmployee(employee); //передаем в employee  детали
//
//            session.beginTransaction();  // открываем транзакци.
//            session.save(employee);
//            session.getTransaction().commit(); // закрываем транзакцию
//
//            System.out.println("DONE");





//            session = factory.getCurrentSession();
//            session.beginTransaction();  // открываем транзакци.
//
//            Detail detail = session.get(Detail.class, 3); // получаем работника по ID
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit(); // закрываем транзакцию



            session = factory.getCurrentSession();
            session.beginTransaction();  // открываем транзакци.

            Detail detail = session.get(Detail.class, 3); // получаем работника по ID
            session.delete(detail);   // удаляем работника из деталей

            //detail.getEmployee().setEmpDetail(null);  // разрушаем связь между деталями и работником

            session.getTransaction().commit(); // закрываем транзакцию



        } finally {
            session.close();
            factory.close();
        }


    }
}
