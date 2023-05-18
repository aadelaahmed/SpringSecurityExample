package com.example.firstexample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employee")
public class Employee {
    @Id
    public Integer id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "middle_name")
    public String middleName;
    @Column(name = "last_name")
    public String lastName;
    public String email;
    public Long phone;
    public Integer pin;
    public Long balance;
    public String password;
    private boolean isEnabled;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean isCredentialsExpired;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities = new ArrayList<>();
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", pin=" + pin +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", isEnabled=" + isEnabled +
                ", isAccountExpired=" + isAccountExpired +
                ", isAccountLocked=" + isAccountLocked +
                ", isCredentialsExpired=" + isCredentialsExpired +
                '}';
    }

    public List<String> getAuthorities() {
        return authorities;
    }
}
