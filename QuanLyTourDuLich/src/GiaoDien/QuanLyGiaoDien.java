/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import QuanLyNhanVIen.EmployeeManagement;
import QuanLyTour.TourManagement;
import QuanLyKhachHang.CustomerManagement;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class QuanLyGiaoDien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int choice = 0;
        System.out.println("Ban muon dang nhap duoi quyen(1. Quan tri, 2. Dieu hanh, 3. Ke Toan): ");
        int login = sc.nextInt();
        if (login == 1) {
            do {
                System.out.println("\n\nChọn chức năng:");
                System.out.println("0. Thoát chương trình.");
                System.out.println("1. Dang nhap vao quan ly nhan vien");
                System.out.println("2. Dang nhap vao quan ly tour");
                System.out.println("3. Dang nhap vao quan ly khach hang");
                System.out.println("Moi nhap lua chon cua ban: ");

                choice = sc.nextInt();
                sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số
                switch (choice) {
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    case 1:
                        EmployeeManagement.main(args);
                        break;
                    case 2:
                        TourManagement.main(args);
                        break;
                    case 3:
                        CustomerManagement.main(args);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            } while (choice != 0);
        }
    }
}
