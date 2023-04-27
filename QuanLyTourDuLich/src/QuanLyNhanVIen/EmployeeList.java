/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyNhanVIen;

import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class EmployeeList {

    private ArrayList<Employee> employeeList;

    public EmployeeList() {
        employeeList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Them thanh cong");
    }

    public boolean deleteEmployee(String idEmployee) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(idEmployee)) {
                employeeList.remove(e);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployee(String id, Employee employee) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(id)) {
                e.setUsername(employee.getUsername());
                e.setPassword(employee.getPassword());
                e.setRole(employee.getRole());
                return true;
            }
        }
        return false;
    }

    public void showEmployeeList() {
        int dem = 0;
        for (Employee employee : employeeList) {
            System.out.println("STT: " + dem);
            System.out.println(employee.toString());
            dem++;
        }
    }

    // Phương thức tìm kiếm nhân viên theo tên
    public ArrayList<Employee> searchEmployeeByName(String name) {
        ArrayList<Employee> result = new ArrayList<Employee>();
        for (Employee emp : employeeList) {
            if (emp.getName().contains(name)) {
                result.add(emp);
            } else {
                System.out.println("Khong co ten " + name + " trong danh sach");
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}