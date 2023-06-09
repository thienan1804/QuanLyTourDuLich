/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TourManagement {

    protected static String linkFile = "D:\\GitHub\\QuanLyTourDuLich\\QuanLyTourDuLich\\src\\QuanLyTour\\DanhSachTour.txt";

    public static void main(String[] args) {
        TourList tourlist = new TourList();
        tourlist.loadFromFile(linkFile);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
            System.out.println("7. Tìm kiếm tour theo ngày đi/ngày về");
            System.out.println("Moi nhap lua chon cua ban: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    tourlist.addTourList(1);
                    break;
                case 2:
                    tourlist.addTourList(2);
                    break;
                case 3:
                    System.out.println("Nhap ma tour muon sua:");
                    String maTourUpdate = sc.next();
                    Tour tourUpdate = new Tour();
                    tourUpdate.nhap();
                    tourlist.updateTour(maTourUpdate, tourUpdate);
                    break;
                case 4:
                    System.out.println("Nhap ma tour can xoa: ");
                    String maTourCanXoa = sc.next();
                    tourlist.deleteTour(maTourCanXoa);
                    break;
                case 5:
                    tourlist.xuat();
                    break;
                case 6:
                    System.out.println("Nhap ten tour: ");
                    String tenFindTour = sc.next();
                    tourlist.findTourByName(tenFindTour);
                    break;
                case 7:
                    // Ngay di phai truoc ngay ve
                    LocalDate ngayDi,
                     ngayVe;
                    String inputNgayDi,
                     inputNgayVe;
                    do {
                        System.out.println("Nhap ngay di: ");
                        inputNgayDi = sc.next();
                        ngayDi = LocalDate.parse(inputNgayDi, format);
                        System.out.println("Nhap ngay ve: ");
                        inputNgayVe = sc.next();
                        ngayVe = LocalDate.parse(inputNgayVe, format);
                        if (ngayDi.isAfter(ngayVe)) {
                            System.out.println("Ngay di phai truoc ngay ve");
                        }
                    } while (ngayDi.isAfter(ngayVe));

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}
