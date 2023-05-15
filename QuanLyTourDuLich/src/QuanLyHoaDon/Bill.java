/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyHoaDon;

import QuanLyKhachHang.Customer;
import QuanLyNhanVIen.Employee;
import QuanLyTour.Tour;
import java.time.LocalDate;

/**
 *
 * @author thien
 */
public class Bill {

    protected String maHoaDon;
    protected Customer khachHang;
    protected Tour tour;
    protected int soLuongKhach;
    protected double giaTour;
    protected LocalDate ngayLapHoaDon;
    protected Employee nguoiLapHoaDon;

    public Bill(String maHoaDon, Customer khachHang, Tour tour, int soLuongKhach, double giaTour, LocalDate ngayLapHoaDon, Employee nguoiLapHoaDon) {
        this.maHoaDon = maHoaDon;
        this.khachHang = khachHang;
        this.tour = tour;
        this.soLuongKhach = soLuongKhach;
        this.giaTour = giaTour;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.nguoiLapHoaDon = nguoiLapHoaDon;
    }

    public Bill() {
        maHoaDon = "";
        khachHang = null;
        tour = null;
        soLuongKhach = 0;
        giaTour = 0;
        ngayLapHoaDon = null;
        nguoiLapHoaDon = null;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Customer getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(Customer khachHang) {
        this.khachHang = khachHang;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getSoLuongKhach() {
        return soLuongKhach;
    }

    public void setSoLuongKhach(int soLuongKhach) {
        this.soLuongKhach = soLuongKhach;
    }

    public double getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(double giaTour) {
        this.giaTour = giaTour;
    }

    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public Employee getNguoiLapHoaDon() {
        return nguoiLapHoaDon;
    }

    public void setNguoiLapHoaDon(Employee nguoiLapHoaDon) {
        this.nguoiLapHoaDon = nguoiLapHoaDon;
    }

    @Override
    public String toString() {
        return "maHoaDon=" + maHoaDon + ", khachHang=" + khachHang.getMaKH()
                + ", tour=" + tour.getMaTour() + ", soLuongKhach=" + soLuongKhach
                + ", giaTour=" + giaTour + ", ngayLapHoaDon=" + ngayLapHoaDon
                + ", nguoiLapHoaDon=" + nguoiLapHoaDon.getEmployeeId();
    }

    public static void main(String[] args) {

    }
}