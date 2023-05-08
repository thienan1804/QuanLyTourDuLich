/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyKhachHang.Customer;
import QuanLyNhanVIen.Employee;
import java.time.LocalDate;

/**
 *
 * @author thien
 */
public class CityTour extends Tour {

    @Override
    public String toString() {
        return "CityTour: " + super.toString() + ", tenThanhPho=" + tenThanhPho;
    }

    public CityTour(String maTour, String tenTour, String ghiChu, LocalDate ngayDi, LocalDate ngayVe, double giaTien, int soLuongKhachToiDa, Employee nguoiTao, Customer khachHang, boolean trangThai, String tenThanhPho) {
        super(maTour, tenTour, ngayDi, ngayVe, giaTien, soLuongKhachToiDa, nguoiTao, khachHang, trangThai, ghiChu);
        this.tenThanhPho = tenThanhPho;
    }

    public CityTour() {
        super();
        tenThanhPho = "";
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap ten thanh pho: ");
        this.tenThanhPho = sc.next();
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    protected String tenThanhPho;

    public static void main(String[] args) {

    }
}
