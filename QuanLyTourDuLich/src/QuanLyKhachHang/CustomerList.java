/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import static QuanLyKhachHang.CustomerManagement.linkFile;
import QuanLyTour.Tour;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            if (cus.getMaKH() != null) {
                if (cus.getMaKH().equals(customer.getMaKH())) {
                    System.out.println("Ma khach hang da ton tai vui long nhap lai!");
                    return;
                }
            } else {
                break;
            }

        }
        customerList.add(customer);
        saveToFile(linkFile);

        System.out.println("Them thanh cong");
    }

    public void deleteCustomer(String idCustomer) {
        for (Customer cus : customerList) {
            if (cus.getMaKH().equals(idCustomer)) {
                customerList.remove(cus);
                System.out.println("Xoa khach hang " + idCustomer + " thanh cong");
                saveToFile(linkFile);
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
                saveToFile(linkFile);
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
        saveToFile(linkFile);
    }

    // Phương thức tìm kiếm khach hang theo tên
    public ArrayList<Customer> findCustomersByName(String name) {
        ArrayList<Customer> result = new ArrayList<Customer>();
        int dem=0;
        for (Customer cus : customerList) {
            if (cus.getTenKH().contains(name)) {
                result.add(cus);
            } else {
                dem++;
            }
        }
        if (dem == customerList.size()) {
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
                String line = kh.toString() + "\n";
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
    public static void loadFromFile(String tenFile) {
        try {
            File file = new File(tenFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Tách thông tin từng thuộc tính của khách hàng từ dòng đọc được
                String[] arr = line.split(",");

                // Lấy giá trị bên trái dấu bằng làm key, giá trị bên phải làm value
                Map<String, String> customerInfo = new HashMap<>();
                for (String s : arr) {
                    String[] temp = s.split("=");

                    if (temp.length >= 2) {
                        customerInfo.put(temp[0].trim(), temp[1].trim());
                    }
                }

                // Tạo đối tượng khách hàng mới từ thông tin đã đọc được
                String maKH = customerInfo.get("maKH");
                String tenKH = customerInfo.get("tenKH");
                String sdt = customerInfo.get("sdt");
                String diaChi = customerInfo.get("diaChi");
                Tour maTour = null;

                Customer customer = new Customer(maKH, tenKH, sdt, diaChi);

                // Thêm khách hàng mới vào danh sách nếu chưa tồn tại trong danh sách
                boolean isExisted = false;
                for (Customer kh : customerList) {
                    if (kh.getMaKH().equals(maKH)) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    customerList.add(customer);
                }
            }

            scanner.close();
            System.out.println("Load danh sách khách hàng từ file thành công.");
        } catch (FileNotFoundException e) {
            System.out.println("Load danh sách khách hàng từ file thất bại: File không tồn tại.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Load danh sách khách hàng từ file thất bại: Lỗi định dạng dữ liệu.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
