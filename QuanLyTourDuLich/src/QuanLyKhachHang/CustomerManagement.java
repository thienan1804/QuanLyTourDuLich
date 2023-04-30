/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import java.util.Scanner;

/**
 *
 * @author thien
 */
public class CustomerManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        CustomerList customerList = new CustomerList();

        do {
            System.out.println("\n\nChọn chức năng:");
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Thêm khách hàng mới.");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Xuất danh sách khách hàng");
            System.out.println("5. Tìm kiếm khách hàng theo tên");
            System.out.println("Moi nhap lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số

            switch (choice) {
                case 1:
                    System.out.println("Nhap ma khach hang: ");
                    String maAddKH = sc.next();
                    System.out.println("Nhap ten khach hang: ");
                    String tenAddKH = sc.next();
                    System.out.println("Nhap sdt khach hang: ");
                    String sdtAddKH = sc.next();
                    System.out.println("Nhap dia chi khach hang: ");
                    String diaChiAddKH = sc.next();
                    Customer cusAdd  = new Customer(maAddKH, tenAddKH, sdtAddKH, diaChiAddKH);
                    customerList.addCustomer(cusAdd);
                    break;
                case 4:
                    customerList.printCustomer();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}
