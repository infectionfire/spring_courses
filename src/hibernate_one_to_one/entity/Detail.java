package hibernate_one_to_one.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String number;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "empDetail",//один к одному или bi-directional
    cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Detail() {
    }

    public Detail(String city, String number, String email) {
        this.city = city;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
