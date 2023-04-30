/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class CustomerList {
    public ArrayList<Customer> customerList;
    
      public CustomerList() {
        customerList = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        for (Customer cus : customerList) {
            if (cus.getMaKH().equals(customer.getMaKH())) {
                System.out.println("Ma khach hang da ton tai vui long nhap lai!");
                return;
            }
        }
        customerList.add(customer);
        System.out.println("Them thanh cong");
    }

    public void Customer(String idCustomer) {
        for (Customer cus : customerList) {
            if (cus.getMaKH().equals(idCustomer)) {
                customerList.remove(cus);
                System.out.println("Xoa khach hang " + idCustomer + " thanh cong");
                return;
            }
        }
        System.out.println("Xoa that bai");
    }

    public void Customer(String idCustomer, Customer customer) {
        for (Customer cus : customerList) {
            if ((cus.getMaKH().equals(idCustomer))) {
                cus.setTenKH(customer.getTenKH());
                cus.setDiaChi(customer.getDiaChi());
                cus.setSdt(cus.getSdt());
                System.out.println("Cap nhat khach hang " + idCustomer + " thanh cong");
                return;
            }
        }
        System.out.println("Cap nhat that bai");
    }

    public void printCustomer() {
        int dem = 0;
        for (Customer cus : customerList) {
            System.out.println("STT: " + dem);
            System.out.println(cus.toString());
            dem++;
        }
    }

    // Phương thức tìm kiếm khach hang theo tên
    public ArrayList<Customer> findCustomersByName(String name) {
        ArrayList<Customer> result = new ArrayList<Customer>();
        boolean check = true;
        for (Customer cus : customerList) {
            if (cus.getTenKH().contains(name)) {
                result.add(cus);
            } else {
                check = false;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay khach hang " + name + " trong danh sach");
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
