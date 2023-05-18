package com.example.firstexample.service;

import com.example.firstexample.config.EmployeeUserDetails;
import com.example.firstexample.model.Employee;
import com.example.firstexample.repository.EmployeeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Test loadUserByUsername method which retruns userdetails object");
        return employeeRepository.findByFirstName(username)
                .map(EmployeeUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Employee Not Found: " + username));
    }
    @PreAuthorize("#userName == authentication.principal.username")
    public String getMyAuthorities(String userName){
        System.out.println("Verified username ->"+userName);
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        EmployeeUserDetails userDetails = (EmployeeUserDetails)authentication.getPrincipal();
        Employee employee = userDetails.getEmployee();
        return employee.getAuthorities().toString();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void checkAuthority(){
        System.out.println("Verified User with ADMIN ROLE");
    }
}
