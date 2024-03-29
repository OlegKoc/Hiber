package hibernate_test2.entity;

import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.*;

@Entity
@Table(name = "details") // привязываем таблицу по принципу One to one (employee к getail)

public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "city")


    private String city;

    @Column(name = "phone_number")

    private String phoneNumber;

    @Column(name = "email")

    private String email;
    @OneToOne(mappedBy = "empDetail", cascade = CascadeType.ALL) //  связь между классами уже налажена в классе Employee

    private Employee employee;



    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Detail() {
    }

    public Detail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Employee getEmployee() {
        return employee;
    }


    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
