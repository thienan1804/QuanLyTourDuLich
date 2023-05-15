/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyHoaDon;

import QuanLyKhachHang.Customer;
import QuanLyNhanVIen.Employee;
import QuanLyTour.Tour;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class BillManagerment {

    protected static String linkFile = "D:\\GitHub\\QuanLyTourDuLich\\QuanLyTourDuLich\\src\\QuanLyHoaDon\\QuanLyHoaDon.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillList billList = new BillList();
        billList.loadFromFile(linkFile);
        int choice = 0;

        do {
            System.out.println("\n\nChọn chức năng:");
            System.out.println("0. Thoát chương trình.");
            System.out.println("1. Thêm hóa đơn mới.");
            System.out.println("2. Xóa hóa đơn");
            System.out.println("3. Tìm kiếm hóa đơn theo mã hóa đơn");
            System.out.println("4. Xuất danh sách hóa đơn");
            System.out.println("5. Tìm kiếm hóa đơn theo mã khách");
            System.out.println("6. Tìm kiếm hóa đơn theo mã hóa đơn");
            System.out.println("Moi nhap lua chon cua ban: ");

            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống sau khi đọc số

            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Nhap ma tour muon lap hoa don: ");
                    String maTourAdd = sc.next();
                    String maHD = "";
                    Customer cusAdd = new Customer();
                    Employee employeeAdd = new Employee();
                    Tour tourAdd = new Tour();
                    int soLuongKhachAdd = 0;
                    double giaTourAdd = 0;
                    boolean checkAdd = false;
                    LocalDate ngayLapHoaDonAdd = LocalDate.now();
                    for (QuanLyTour.Tour tour : QuanLyTour.TourList.tour) {
                        if (tour != null) {
                            if (tour.getMaTour().equals(maTourAdd)) {
                                if (tour.getTrangThai()) {
                                    System.out.println("Nhap ma hoa don");
                                    maHD = sc.next();
                                    cusAdd.setMaKH(tour.getKhachHang().getMaKH());
                                    employeeAdd.setEmployeeId(tour.getNguoiTao().getEmployeeId());
                                    tourAdd = tour;
                                    soLuongKhachAdd = tour.getSoLuongKhach();
                                    giaTourAdd = tour.getGiaTienDuocGiam();
                                    break;
                                } else {
                                    System.out.println("Tour này chưa được xác nhận");
                                    break;
                                }
                            } else {
                                System.out.println("Tour này không có trong danh sách");
                            }
                        }
                    }
                    if (checkAdd) {
                        Bill billAdd = new Bill(maHD, cusAdd, tourAdd, soLuongKhachAdd, giaTourAdd, ngayLapHoaDonAdd, employeeAdd);
                        billList.addBill(billAdd);
                    } else {
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Nhập mã hóa đơn cần xóa: ");
                    String maBillDelete = sc.next();
                    billList.deleteBill(maBillDelete);
                    break;
                case 3:
                    System.out.println("Nhập mã hóa đơn muốn tìm kiếm: ");
                    String maBillFind = sc.next();
                    billList.findBillById(maBillFind);
                    break;
                case 4:
                    billList.showBillList();
                    break;
                case 5:
                    System.out.println("Nhập mã khách hàng muốn tìm kiếm: ");
                    String maCusFind = sc.next();
                    billList.findBillByCustomer(maCusFind);
                    break;
                case 6:
                    System.out.println("Nhập mã nhân viên muốn tìm kiếm: ");
                    String maEmployeeFind = sc.next();
                    billList.findBillByEmployee(maEmployeeFind);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}
