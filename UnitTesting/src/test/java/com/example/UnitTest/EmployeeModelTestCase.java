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

@SpringBootTest
public class EmployeeModelTestCase {

EmployeeModel employeemodel;

@BeforeEach
public void setUp() { 
employeemodel= new EmployeeModel();
}

@Test
public void testEmp_id() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setEmp_id(1234L);
 // Act
 // Assert
 Assertions.assertEquals(1234L, employee.getEmp_id());
}

@Test
public void testAge() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setAge(30);
 // Act
 // Assert
 Assertions.assertEquals(30, employee.getAge());
}

@Test
public void testEmployeeFirstName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setEmployeeFirstName("John");
 // Act
 // Assert
 Assertions.assertEquals("John", employee.getEmployeeFirstName());
}

@Test
public void testEmployeeLastName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setEmployeeLastName("John");
 // Act
 // Assert
 Assertions.assertEquals("John", employee.getEmployeeLastName());
}

@Test
public void testphoneNumber() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setPhoneNumber("John");
 // Act
 // Assert
 Assertions.assertEquals("John", employee.getPhoneNumber());
}

@Test
public void testEmailID() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 employee.setEmailID("John");
 // Act
 // Assert
 Assertions.assertEquals("John", employee.getEmailID());
}

@Test
public void testGetEmployeeFirstName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 employee.getEmployeeFirstName();
 // Act
 String result = employee.getEmployeeFirstName();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getEmployeeFirstName ");
}

@Test
public void testSetEmployeeFirstName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 // Act
 employee.setEmployeeFirstName(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getEmployeeFirstName()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

@Test
public void testSetEmployeeLastName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 // Act
 employee.setEmployeeLastName(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getEmployeeLastName()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

@Test
public void testGetEmployeeLastName() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 employee.getEmployeeLastName();
 // Act
 String result = employee.getEmployeeLastName();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getEmployeeLastName ");
}

@Test
public void testGetPhoneNumber() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 employee.getPhoneNumber();
 // Act
 String result = employee.getPhoneNumber();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getPhoneNumber ");
}

@Test
public void testSetAge() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 int expectedValue = 0;
 // Act
 employee.setAge(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getAge()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

@Test
public void testGetAge() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 int expectedValue = 0;
 employee.getAge();
 // Act
 int result = employee.getAge();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getAge ");
}

@Test
public void testGetEmailID() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 employee.getEmailID();
 // Act
 String result = employee.getEmailID();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getEmailID ");
}

@Test
public void testSetEmp_id() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 Long expectedValue = null;
 // Act
 employee.setEmp_id(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getEmp_id()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

@Test
public void testGetEmp_id() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 Long expectedValue = null;
 employee.getEmp_id();
 // Act
 Long result = employee.getEmp_id();
 // Assert
 Assertions.assertEquals(expectedValue, result, "getEmp_id ");
}

@Test
public void testSetPhoneNumber() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 // Act
 employee.setPhoneNumber(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getPhoneNumber()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

@Test
public void testSetEmailID() {
 // Arrange
 EmployeeModel employee = new EmployeeModel();
 String expectedValue = null;
 // Act
 employee.setEmailID(expectedValue);
 // Assert
 SoftAssertions softAssertions = new SoftAssertions();
 softAssertions.assertThat(employee.getEmailID()).isEqualTo(expectedValue);
 softAssertions.assertAll();
}

}
