/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyNhanVIen;

import static QuanLyNhanVIen.EmployeeManagement.linkFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.io.FileWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class EmployeeList {

    public static ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public EmployeeList() {
        employeeList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(employee.getEmployeeId())) {
                System.out.println("Ma nhan vien da ton tai vui long nhap lai!");
                return;
            }
        }
        employeeList.add(employee);
        saveToFile(linkFile);
        System.out.println("Them thanh cong");
    }

    public void deleteEmployee(String idEmployee) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(idEmployee)) {
                employeeList.remove(e);
                System.out.println("Xoa nhan vien " + idEmployee + " thanh cong");
                saveToFile(linkFile);
                return;
            }
        }
        System.out.println("Xoa that bai");
    }

    public void updateEmployee(String id, Employee employee) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equals(id)) {
                e.setUsername(employee.getUsername());
                e.setPassword(employee.getPassword());
                e.setRole(employee.getRole());
                System.out.println("Cap nhat nhan vien " + id + " thanh cong");
                saveToFile(linkFile);
                return;
            }
        }
        System.out.println("Cap nhat that bai");
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
        boolean check = true;
        for (Employee emp : employeeList) {
            if (emp.getName().contains(name)) {
                result.add(emp);
            } else {
                check = false;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay nhan vien " + name + " trong danh sach");
        }
        return result;
    }

    // Hàm lưu danh sách vào file
    public void saveToFile(String filePath) {
        int dem = 0;
        try {
            FileWriter writer = new FileWriter(filePath);

            // Duyệt qua danh sách nhan vien và ghi thông tin của từng nhan vien vào file
            for (Employee e : employeeList) {
                String line = e.toString() + "\n";
                writer.write(line);
                dem++;
            }

            writer.close();
            System.out.println("Lưu danh sách nhan vien vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lưu danh sách nhan vien vào file thất bại.");
            e.printStackTrace();
        }
    }

    // Ham lay du lieu tu file
    public static void loadFromFile(String tenFile) {
        try {
            File file = new File(tenFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Tách thông tin từng thuộc tính của nhan vien từ dòng đọc được
                String[] arr = line.split(",");

                // Lấy giá trị bên trái dấu bằng làm key, giá trị bên phải làm value
                Map<String, String> emoloyeeInfo = new HashMap<>();
                for (String s : arr) {
                    String[] temp = s.split("=");

                    if (temp.length >= 2) {
                        emoloyeeInfo.put(temp[0].trim(), temp[1].trim());
                    }
                }

                // Tạo đối tượng nhan vien mới từ thông tin đã đọc được
                String maNV = emoloyeeInfo.get("employeeId");
                String tenNV = emoloyeeInfo.get("name");
                String username = emoloyeeInfo.get("username");
                String password = emoloyeeInfo.get("password");
                String role = emoloyeeInfo.get("role");

                Employee employee = new Employee(maNV, tenNV, username, password, role);

                // Thêm nhan vien mới vào danh sách nếu chưa tồn tại trong danh sách
                boolean isExisted = false;
                for (Employee e : employeeList) {
                    if (e.getEmployeeId().equals(maNV)) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    employeeList.add(employee);
                }
            }

            scanner.close();
            System.out.println("Load danh sách nhan vien từ file thành công.");
        } catch (FileNotFoundException e) {
            System.out.println("Load danh sách nhan vien từ file thất bại: File không tồn tại.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Load danh sách nhan vien từ file thất bại: Lỗi định dạng dữ liệu.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
