/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QuanLyNhanVIen;

import java.util.Scanner;

/**
 *
 * @author thien
 */
public class Employee {

    protected String employeeId;
    protected String name;
    protected String username;
    protected String password;
    protected String role;
    Scanner sc = new Scanner(System.in);

    public Employee(String employeeId, String name, String username, String password, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Employee() {
        employeeId = "";
        name = "";
        username = "";
        password = "";
        role = "";
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "employeeId=" + employeeId + ", name=" + name + ", username=" + username
                + ", password=" + password + ", role=" + role ;
    }

    public static void main(String[] args) {

    }
}
