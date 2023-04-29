/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyNhanVIen.Employee;
import QuanLyNhanVIen.EmployeeList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    
    protected boolean trangThai;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tour(String maTour, String tenTour, String ghiChu, LocalDate ngayDi, LocalDate ngayVe, double giaTien, int soLuongKhachToiDa, Employee nguoiTao, boolean trangThai) {
        this.maTour = maTour;
        this.tenTour = tenTour;
        this.ghiChu = ghiChu;
        this.ngayDi = ngayDi;
        this.ngayVe = ngayVe;
        this.giaTien = giaTien;
        this.soLuongKhachToiDa = soLuongKhachToiDa;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
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
    }

    protected void nhap() {
        System.out.println("Nhap ten Tour: ");
        this.tenTour = sc.next();
        do {
            System.out.println("Nhap ngay di: ");
            String inputNgayDi = sc.next();
            this.ngayDi = LocalDate.parse(inputNgayDi, format);
            System.out.println("Nhap ngay ve: ");
            String inputNgayVe = sc.next();
            this.ngayVe = LocalDate.parse(inputNgayVe, format);
            if(this.ngayDi.isAfter(ngayVe))System.out.println("Ngay di phai truoc ngay ve");
        }while(this.ngayDi.isAfter(ngayVe));  
        System.out.println("Nhap gia tien: ");
        this.giaTien = sc.nextDouble();
        System.out.println("Nhap so luong khach toi da: ");
        this.soLuongKhachToiDa = sc.nextInt();
        String ma;
        do {
            System.out.println("Nhap ma nguoi tao: ");
            ma = sc.next();
        } while (this.nguoiTao.getEmployeeId().equals(ma));

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

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Tour: {" + "maTour=" + maTour + ", tenTour=" + tenTour + ", ghiChu=" + ghiChu
                + ", ngayDi=" + ngayDi + ", ngayVe=" + ngayVe + ", giaTien=" + giaTien
                + ", soLuongKhachToiDa=" + soLuongKhachToiDa + ", nguoiTao=" + nguoiTao + ", trangThai=" + trangThai;
    }

    public static void main(String[] args) {

    }
}
