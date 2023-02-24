package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

// класс где мы обновляем информацию в БД
public class Test4 {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        try {


            Session session = factory.getCurrentSession(); // открываем сессию


            session.beginTransaction();  // открываем транзакцию
//            Employee employee = session.get(Employee.class, 1); // получаем работника по ID
//            employee.setSalary(1500); // меняем зарплату(salary)

            session.createQuery
                    ("update Employee set    salary  = 1111" + "where  surname = 'Kochurova'" ).executeUpdate(); // увеличиваем зарплату (salary) работникам с фамилией Kochurova


            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf("Done");


        } finally {
            factory.close();
        }
    }


}


