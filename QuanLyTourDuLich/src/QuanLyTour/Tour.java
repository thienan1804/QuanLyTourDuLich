/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyKhachHang.Customer;
import QuanLyKhachHang.CustomerList;
import QuanLyNhanVIen.Employee;
import QuanLyNhanVIen.EmployeeList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class Tour {

    protected String maTour, tenTour, ghiChu;
    protected LocalDate ngayDi, ngayVe;
    protected double giaTien;
    protected int soLuongKhachToiDa;
    protected Employee nguoiTao;
    protected Customer khachHang;
    String ma, maKhachDaiDien;
    boolean check, checkMaKhachHang;

    protected boolean trangThai;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tour(String maTour, String tenTour, LocalDate ngayDi, LocalDate ngayVe, double giaTien, int soLuongKhachToiDa, Employee nguoiTao, Customer khachHang, boolean trangThai, String ghiChu) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.ghiChu = ghiChu;
        this.ngayDi = ngayDi;
        this.ngayVe = ngayVe;
        this.giaTien = giaTien;
        this.soLuongKhachToiDa = soLuongKhachToiDa;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
        this.khachHang = khachHang;
    }

    public Tour() {
        maTour = "";
        tenTour = "";
        ghiChu = "";
        ngayDi = LocalDate.now();
        ngayVe = LocalDate.now();
        giaTien = 0;
        soLuongKhachToiDa = 0;
        nguoiTao = new Employee();
        trangThai = false;
        this.khachHang = new Customer();
    }

    protected void nhap() {
//        System.out.println("Nhap ten Tour: ");
//        this.tenTour = sc.next();

        // Ngay di phai truoc ngay ve
//        do {
//            System.out.println("Nhap ngay di: ");
//            String inputNgayDi = sc.next();
//            this.ngayDi = LocalDate.parse(inputNgayDi, format);
//            System.out.println("Nhap ngay ve: ");
//            String inputNgayVe = sc.next();
//            this.ngayVe = LocalDate.parse(inputNgayVe, format);
//            if (this.ngayDi.isAfter(ngayVe)) {
//                System.out.println("Ngay di phai truoc ngay ve");
//            }
//        } while (this.ngayDi.isAfter(ngayVe));
        System.out.println("Nhap gia tien(trieu): ");
        this.giaTien = sc.nextDouble();
        System.out.println("Nhap so luong khach toi da: ");
        this.soLuongKhachToiDa = sc.nextInt();

//         Kiem tra xem nhan vien co ton tai khong
        do {
            System.out.println("Nhap ma nguoi tao: ");
            ma = sc.next();
            for (Employee e : EmployeeList.employeeList) {
                if (e != null) {
                    if (!e.getEmployeeId().equals(ma)) {
                        check = false;
                    } else {
                        check = true;
                        break;
                    }
                } else {
                    System.out.println("Danh sach nhan vien chua co du lieu");
                }
            }
            if (!check) {
                System.out.println("Khong co nhan vien trong danh sach!");
            } else {
                nguoiTao.setEmployeeId(ma);
            }
        } while (!check);
        // Nhap danh sach khach hang
        do {
            System.out.println("Nhap ma khach hang dai dien: ");
            maKhachDaiDien = sc.next();
            for (Customer cus : CustomerList.customerList) {
                if (cus != null) {
                    if (!cus.getMaKH().equals(maKhachDaiDien)) {
                        checkMaKhachHang = false;
                    } else {
                        checkMaKhachHang = true;
                        break;
                    }
                } else {
                    System.out.println("Danh sach khach hang chua co du lieu");
                }
            }
            if (!checkMaKhachHang) {
                System.out.println("Khong co khach hang trong danh sach!");
            } else {
                khachHang.setMaKH(maKhachDaiDien);
            }
        } while (!checkMaKhachHang);

        for (Customer cus : CustomerList.customerList) {
            if (cus != null) {
                if (cus.getMaKH().equals(khachHang.getMaKH())) {
                    cus.getMaTour();
                }
            }
        }

//        System.out.println("Nhap ghi chu: ");
//        this.ghiChu = sc.next(); 
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public void setDsKhachHang(Customer khachHang) {
        this.khachHang = khachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public LocalDate getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(LocalDate ngayDi) {
        this.ngayDi = ngayDi;
    }

    public LocalDate getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(LocalDate ngayVe) {
        this.ngayVe = ngayVe;
    }

    public double getGiaTien() {
        if (this.soLuongKhachToiDa >= 3 && this.giaTien > 30) {
            return giaTien * 0.1;
        }
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuongKhachToiDa() {
        return soLuongKhachToiDa;
    }

    public void setSoLuongKhachToiDa(int soLuongKhachToiDa) {
        this.soLuongKhachToiDa = soLuongKhachToiDa;
    }

    public Employee getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(Employee nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public Customer getKhachHang() {
        return khachHang;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        String trangThaiString = !this.trangThai ? "Dang mo ban" : "Da dong";
        return "maTour=" + maTour + ", tenTour=" + tenTour + ", ngayDi="
                + ngayDi.format(format) + ", ngayVe=" + ngayVe.format(format) + ", giaTien=" + getGiaTien() + "tr"
                + ", soLuongKhachToiDa=" + soLuongKhachToiDa + ", nguoiTao=" + nguoiTao.getEmployeeId()
                + ", trangThai=" + trangThaiString + ", khachHang=" + khachHang.getMaKH() + ", ghiChu=" + ghiChu;
    }

    public static void main(String[] args) {

    }
}
