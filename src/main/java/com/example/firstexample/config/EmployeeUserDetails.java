package com.example.firstexample.config;

import com.example.firstexample.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class EmployeeUserDetails implements UserDetails {
    private final Employee employee;

    public EmployeeUserDetails(Employee employee) {
        this.employee = employee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("Test getAuthorities method in employeesuserdetails class");
        return employee.getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        System.out.println("test the getpassword method ->"+employee.getPassword());
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("test the getUserName method ->"+employee.getFirstName());
        return employee.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !employee.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !employee.isAccountLocked();
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !employee.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return employee.isEnabled();
    }
}
