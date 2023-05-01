/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author thien
 */
public class CustomerList {

    public static ArrayList<Customer> customerList;

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

    public void deleteCustomer(String idCustomer) {
        for (Customer cus : customerList) {
            if (cus.getMaKH().equals(idCustomer)) {
                customerList.remove(cus);
                System.out.println("Xoa khach hang " + idCustomer + " thanh cong");
                return;
            }
        }
        System.out.println("Xoa that bai");
    }

    public void updateCustomer(String idCustomer, Customer customer) {
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

    // Hàm lưu danh sách vào file
    public void saveToFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);

            // Duyệt qua danh sách khách hàng và ghi thông tin của từng khách hàng vào file
            for (Customer kh : customerList) {
                String line = kh.getMaKH() + "," + kh.getTenKH() + ","
                        + kh.getSdt() + "," + kh.getDiaChi() + kh.maTour.getMaTour() + "," + kh.loaiKhachHang + "\n";
                writer.write(line);
            }

            writer.close();
            System.out.println("Lưu danh sách khách hàng vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lưu danh sách khách hàng vào file thất bại.");
            e.printStackTrace();
        }
    }

    // Ham lay du lieu tu file
    public void loadFromFile(String tenFile) {
        try {
            FileReader fr = new FileReader(tenFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String MaKH = parts[0];
                String tenKH = parts[1];
                String sdt = parts[2];
                String diaChi = parts[3];
                Customer kh = new Customer(MaKH, tenKH, sdt, diaChi);
                customerList.add(kh);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Ham xoa khach hang khoi file 
    public void deleteFromFile(String customerId, String filePath) {
        // Đọc toàn bộ danh sách khách hàng từ file vào một ArrayList
        loadFromFile(filePath);

        // Tìm kiếm khách hàng cần xóa
        Customer customerToDelete = null;
        for (Customer customer : customerList) {
            if (customer.getMaKH().equals(customerId)) {
                customerToDelete = customer;
                break;
            }
        }

        // Nếu tìm thấy khách hàng cần xóa, xóa khỏi danh sách
        if (customerToDelete != null) {
            customerList.remove(customerToDelete);
            System.out.println("Đã xóa thông tin khách hàng với mã " + customerId);
            // Lưu lại danh sách khách hàng mới vào file
            saveToFile(filePath);
        } else {
            System.out.println("Không tìm thấy thông tin khách hàng với mã " + customerId);
        }

    }

    public static void main(String[] args) {

    }
}
