package koltun.registration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participant {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;
    private Boolean confirmed;

    public Participant() {}

    public Participant(String firstName, String lastName, String phone, String email) {
        this(firstName, lastName, phone, email, false);
    }

    public Participant(String firstName, String lastName, String phone, String email, boolean confirmed) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        setConfirmed(confirmed);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
