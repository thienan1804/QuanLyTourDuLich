/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import QuanLyTour.Tour;
import QuanLyTour.TourList;
import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class Customer {

    String maKH, tenKH, sdt, diaChi;
    int loaiKhachHang;
    Tour maTour;

    public Customer(String maKH, String tenKH, String sdt, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.loaiKhachHang = 2;
        this.maTour = new Tour();
    }

    public Customer() {
        this.maKH = "";
        this.tenKH = "";
        this.sdt = "";
        this.diaChi = "";
        this.loaiKhachHang = 2;
        this.maTour = new Tour();
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Tour getMaTour() {
        boolean checkMaKHTour;
        for (Tour tour : TourList.tour) {
            for (String maKHTour : tour.getDsKhachHang()) {
                if (maKHTour.equals(maKH)) {
                    checkMaKHTour = true;
                    return maTour = tour;
                }
            }
        }
        return maTour;
    }

    public void setMaTour(Tour maTour) {
        this.maTour = maTour;
    }

    public int getLoaiKhachHang() {
        for (Tour tour : TourList.tour) {
            if (!tour.getDsKhachHang().isEmpty()) {
                for (String maKh : tour.getDsKhachHang()) {
                    if (maKh.equals(this.maKH)) {
                        if (tour.getGiaTien() > 30) {
                            return loaiKhachHang = 1;

                        }
                    }
                }
            } 
        }
        return loaiKhachHang = 2;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public String toString() {
        String loaiKHString = loaiKhachHang == 1 ? "Vip" : "Thuong";
        return "Customer{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt
                + ", diaChi=" + diaChi + ", maTour=" + maTour.getMaTour() + ", loaiKhachHang=" + loaiKHString + '}';
    }

    public static void main(String[] args) {

    }
}
