/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVIen;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        EmployeeList employeeList = new EmployeeList();
        int choice = 0;
        do {
            System.out.println("\n\nChọn chức năng:");
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Thêm nhân viên mới.");
            System.out.println("2. Sửa thông tin nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Xuất danh sách nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("Moi nhap lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số

            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.print("Nhap ma nhan vien: ");
                    String employeeId = sc.next();
                    System.out.print("Nhap ten nhan vien: ");
                    String name = sc.next();
                    System.out.print("Nhap tai khoan: ");
                    String username = sc.next();
                    System.out.print("Nhap mat khau: ");
                    String password = sc.next();
                    int role;
                    do {
                        System.out.print("Nhap vai tro (1:Quan tri, 2:Dieu hanh, 3: Ke Toan): ");
                        role = sc.nextInt();
                        if (role != 1 && role != 2 && role != 3) {
                            System.out.println("Loi! Vui long nhap lai");
                        }
                    } while (role != 1 && role != 2 && role != 3);
                    Employee employeeToAdd = new Employee(employeeId, name, username, password, role);
                    employeeList.addEmployee(employeeToAdd);
                    break;
                case 2:
                    System.out.print("Nhap ma nhan vien muon sua: ");
                    String employeeIdToUpdate = sc.next();
                    System.out.print("Nhap ten nhan vien: ");
                    String nameUpdate = sc.next();
                    System.out.print("Nhap tai khoan: ");
                    String usernameUpdate = sc.next();
                    System.out.print("Nhap mat khau: ");
                    String passwordUpdate = sc.next();
                    int roleUpdate;
                    do {
                        System.out.print("Nhap vai tro (1:Quan tri, 2:Dieu hanh, 3: Ke Toan): ");
                        roleUpdate = sc.nextInt();
                        if (roleUpdate != 1 && roleUpdate != 2 && roleUpdate != 3) {
                            System.out.println("Loi! Vui long nhap lai");
                        }
                    } while (roleUpdate != 1 && roleUpdate != 2 && roleUpdate != 3);
                    Employee employeeToUpdate = new Employee(employeeIdToUpdate, nameUpdate, usernameUpdate, passwordUpdate, roleUpdate);
                    employeeList.updateEmployee(employeeIdToUpdate, employeeToUpdate);
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien: ");
                    String employeeIdDelete = sc.next();
                    employeeList.deleteEmployee(employeeIdDelete);
                    break;
                case 4:
                    employeeList.showEmployeeList();
                    break;
                case 5:
                    System.out.print("Nhap ten nhan vien: ");
                    String nameSearch = sc.next();
                    int dem = 0;
                    ArrayList<Employee> result = employeeList.searchEmployeeByName(nameSearch);
                    for (Employee employee : result) {
                        System.out.println("STT: " + dem);
                        System.out.println(employee.toString());
                        dem++;
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    
    }
}
