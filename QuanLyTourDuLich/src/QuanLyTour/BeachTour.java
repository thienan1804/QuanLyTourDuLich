/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyNhanVIen.Employee;
import java.time.LocalDate;

/**
 *
 * @author thien
 */
public class BeachTour extends Tour {

    protected String tenBien, tenKhachSan;

    public BeachTour(String maTour, String tenTour, String ghiChu, LocalDate ngayDi, LocalDate ngayVe, double giaTien, int soLuongKhachToiDa, Employee nguoiTao, boolean trangThai, String tenBien, String tenKhachSan) {
        super(maTour, tenTour, ghiChu, ngayDi, ngayVe, giaTien, soLuongKhachToiDa, nguoiTao, trangThai);
        this.tenBien = tenBien;
        this.tenKhachSan = tenKhachSan;
    }

    public BeachTour() {
        super();
        tenBien = "";
        tenKhachSan = "";
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap ten bien: ");
        this.tenBien = sc.next();
        System.out.println("Nhap ten khach san: ");
        this.tenKhachSan = sc.next();

    }

    public String getTenBien() {
        return tenBien;
    }

    public void setTenBien(String tenBien) {
        this.tenBien = tenBien;
    }

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    @Override
    public String toString() {
        return "BeachTour: " + super.toString() + ", tenBien=" + tenBien + ", tenKhachSan=" + tenKhachSan + '}';
    }

}
