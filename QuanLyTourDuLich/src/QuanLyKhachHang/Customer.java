/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import QuanLyTour.Tour;
import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class Customer {

    String maKH, tenKH, sdt, diaChi;
    int loaiKhachHang;
    Tour maTour;
    ArrayList<Tour> tourList;

    public Customer(String maKH, String tenKH, String sdt, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.maTour=getMaTour();
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
        if(tourList!=null){
             for (Tour tour : tourList) {
             for (String maKh : tour.getDsKhachHang()) {
                    if (maKh.equals(this.maKH)) {
                            return maTour = tour;
                    }
                }
             }
        }
        return maTour;
    }

    public void setMaTour(Tour maTour) {
        this.maTour = maTour;
    }

    public int getLoaiKhachHang() {
        if (tourList != null) {
            for (Tour tour : tourList) {
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
        return "Customer{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt
                + ", diaChi=" + diaChi + ", maTour=" + maTour.getMaTour() + ", loaiKhachHang=" + getLoaiKhachHang() + '}';
    }

    public static void main(String[] args) {

    }
}
