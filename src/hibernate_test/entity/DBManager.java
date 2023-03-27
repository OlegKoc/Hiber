package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBManager {


    public static void createImployee(String name, String surname, String department, int salary) {


        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml") // читает данный файл
                .addAnnotatedClass(Employee.class) //
                .buildSessionFactory(); //

        try {
            Session session = factory.getCurrentSession(); // подключение к БД

            Employee emp = new Employee(name, surname, department, salary); // создаем работника
            session.beginTransaction();  // открываем транзакцию
            session.save(emp); // сохраняем объект в базу

            session.getTransaction().commit(); // закрываем транзакцию
            System.out.println("DONE");
        } finally {
            factory.close();
        }


    }

    public static void receiveImployees(int id) {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // открываем сессию


            session.beginTransaction();  // открываем транзакцию


            Employee employee = session.get(Employee.class, id); //получаем работника по ID
            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf(String.valueOf(employee));// выводим в консоль

        } finally {
            factory.close();
        }

    }

    public static void getAllEmployees() {
        SessionFactory factory = new Configuration() //создаем объект сессии
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // открываем сессию

            session.beginTransaction();  // открываем транзакцию
            List<Employee> emps = session.createQuery("from Employee").getResultList();// получаем всех работников из БД
            for (Employee e : emps) {
                System.out.println(e);

            }

            session.getTransaction().commit(); // закрываем транзакцию
            System.out.printf("Done");

        } finally {
            factory.close();
        }
    }

    public static void getEmployee() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee " + "where name = 'Roman' AND salary>500").getResultList(); // получаем работника из БД по заданным условиям
        for (Employee employee : employees) {
            System.out.println(employee);

        }
        session.getTransaction().commit();


    }

    public static void employeeСhange(int id) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {


            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, id);
            emp.setSalary(1600);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }

    public static void  employeesChange(){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Employee set salary = 1000 where firstName = 'Roman'").executeUpdate();
            session.getTransaction();

        }
        finally {
            factory.close();
        }

    }

    public static void  employeesDelete(){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 5);
            session.delete(emp);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

}

