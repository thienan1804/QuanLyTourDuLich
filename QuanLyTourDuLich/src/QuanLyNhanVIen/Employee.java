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
    protected int role;
    Scanner sc = new Scanner(System.in);

    public Employee(String employeeId, String name, String username, String password, int role) {
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
        role = 0;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        String returnRole = "";
        switch (this.role) {
            case 1:
                returnRole = "Quan Tri";
                break;
            case 2:
                returnRole = "Dieu Hanh";
                break;
            default:
                returnRole = "Ke Toan";
                break;
        }
        return "Employee: {" + "employeeId=" + employeeId + ", name=" + name + ", username=" + username
                + ", password=" + password + ", role=" + returnRole + '}';
    }

    public static void main(String[] args) {

    }
}