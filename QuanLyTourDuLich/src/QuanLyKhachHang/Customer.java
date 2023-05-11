/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import QuanLyTour.Tour;
import QuanLyTour.TourList;

/**
 *
 * @author thien
 */
public class Customer {

    String maKH, tenKH, sdt, diaChi;
    int loaiKhachHang;
    String maTour;

    public Customer(String maKH, String tenKH, String sdt, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.loaiKhachHang = 2;
        this.maTour = "";
    }

    public Customer() {
        this.maKH = "";
        this.tenKH = "";
        this.sdt = "";
        this.diaChi = "";
        this.loaiKhachHang = 2;
        this.maTour = "";
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

    public String getMaTour() {
        for (Tour tour : TourList.tour) {
            if (tour != null) {
                if (tour.getKhachHang().getMaKH().equals(maKH)) {
                    return maTour = tour.getMaTour();
                }
            }
        }
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public int getLoaiKhachHang() {
        for (Tour tour : TourList.tour) {
            if (tour != null) {
                if (tour.getKhachHang().getMaKH().equals(maKH)) {
                    if (tour.getGiaTien() > 30 && tour.getSoLuongKhach() > 3) {
                        return loaiKhachHang = 1;
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
        String loaiKHString = getLoaiKhachHang() == 1 ? "Vip" : "Thuong";
        return "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt
                + ", diaChi=" + diaChi + ", maTour=" + getMaTour() + ", loaiKhachHang=" + loaiKHString;
    }

    public static void main(String[] args) {

    }
}
