package hibernate_test.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {


        //DBManager.createImployee("Oleg", "Kochurov", "IT", 1000); // вызываем метод по созданию работника из класса DBManager.

       // DBManager.receiveImployees(2); // получаем работника по его id

        //DBManager.getAllEmployees();

        DBManager.getEmployee();




    }


}
