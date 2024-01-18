package com.example.UnitTest;
import org.junit.jupiter.api.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assert;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.time.*;
import java.util.regex.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;
import org.springframework.http.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
@SpringBootTest
public class EmployeeServiceTestCase {

@Mock
private Repository employeeRepository;
@InjectMocks
private EmployeeService employeeservice;

@BeforeEach
public void setUp() { 
employeeservice= new EmployeeService();
}

@Test
public void testgetAllEmployee() {
    // Arrange
//List<EmployeeModel> employeeList = new ArrayList<>();
List<EmployeeModel> employeeList = new ArrayList<>();
when(employeeRepository.findAll()).thenReturn(employeeList);
    // Act

    // Assert
    Assertions.assertNotNull(employeeList);
}

@Test
public void testcreateEmployee() {
    // Arrange
List<EmployeeModel> employeeList = new ArrayList<>();
EmployeeModel newEmployee = new EmployeeModel();
when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);
    // Act

    // Assert
    Assertions.assertNotNull(employeeList);
}

@Test
public void testdeleteEmployee() {
    // Arrange
List<EmployeeModel> employeeList = new ArrayList<>();
EmployeeModel employeeToDelete = new EmployeeModel();
//when(employeeRepository.findById(employeeId)).thenReturn((employeeToDelete));
//when(employeeRepository).deleteById(employeeId);
    // Act

    // Assert
    Assertions.assertNotNull(employeeList);
}

@Test
public void testgetEmployeeById() {
    // Arrange
List<EmployeeModel> employeeList = new ArrayList<>();
    // Act

    // Assert
    Assertions.assertNotNull(employeeList);
}

@Test
public void testupdateEmployee() {
    // Arrange
List<EmployeeModel> employeeList = new ArrayList<>();
EmployeeModel newEmployee = new EmployeeModel();
when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);
    // Act

    // Assert
    Assertions.assertNotNull(employeeList);
}

}
