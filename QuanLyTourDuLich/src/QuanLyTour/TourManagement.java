/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import java.util.Scanner;

/**
 *
 * @author thien
 */
public class TourManagement {

    public static void main(String[] args) {
        TourList tourlist = new TourList();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\nChọn chức năng:");
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Thêm tour đi biển.");
            System.out.println("2. Thêm tour đi thành phố.");
            System.out.println("3. Sửa thông tin tour");
            System.out.println("4. Xóa tour");
            System.out.println("5. Xuất danh sách tour");
            System.out.println("6. Tìm kiếm tour theo tên");
            System.out.println("Moi nhap lua chon cua ban: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    tourlist.addTourList(1);
                    break;
                case 2:
                    tourlist.addTourList(2);
                    break;
                case 4:
                    System.out.println("Nhap ma tour can xoa: ");
                    String maTourCanXoa = sc.next();
                    tourlist.deleteTour(maTourCanXoa);
                case 5:
                    tourlist.xuat();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}