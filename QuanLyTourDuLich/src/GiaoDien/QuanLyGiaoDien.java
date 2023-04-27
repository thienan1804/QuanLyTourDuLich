/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import QuanLyNhanVIen.EmployeeManagement;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class QuanLyGiaoDien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n\nChọn chức năng:");
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Dang nhap vao quan ly nhan vien");
            System.out.println("Moi nhap lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số
            switch (choice) {
                case 1:
                    EmployeeManagement.main();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
        EmployeeManagement.main();

    }
}
