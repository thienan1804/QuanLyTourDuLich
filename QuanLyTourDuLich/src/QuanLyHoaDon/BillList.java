/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyHoaDon;

import static QuanLyHoaDon.BillManagerment.linkFile;
import QuanLyKhachHang.Customer;
import QuanLyNhanVIen.Employee;
import QuanLyTour.Tour;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author thien
 */
public class BillList {

    public static ArrayList<Bill> billList;

    public ArrayList<Bill> getbillList() {
        return billList;
    }

    public BillList() {
        billList = new ArrayList<Bill>();
    }

    // Phương thức thêm hóa đơn
    public void addBill(Bill bill) {
        for (Bill b : billList) {
            if (b.getMaHoaDon().equals(bill.getMaHoaDon())) {
                System.out.println("Ma hoa don da ton tai vui long nhap lai!");
                return;
            }
        }
        billList.add(bill);
        saveToFile(linkFile);
        System.out.println("Them thanh cong");
    }

    // Xóa hóa đơn
    public void deleteBill(String maHoaDon) {
        for (Bill b : billList) {
            if (b.getMaHoaDon().equals(maHoaDon)) {
                billList.remove(b);
                System.out.println("Xoa hoa don " + maHoaDon + " thanh cong");
                saveToFile(linkFile);
                return;
            }
        }
        System.out.println("Xoa that bai");
    }

    //show bill
    public void showBillList() {
        int dem = 0;
        for (Bill b : billList) {
            System.out.println("STT: " + dem);
            System.out.println(b.toString());
            dem++;
        }
    }

    // Phương thức tìm kiếm hóa đơn theo mã hóa đơn
    public Bill findBillById(String billId) {
        for (Bill bill : billList) {
            if (bill.getMaHoaDon().equals(billId)) {
                return bill;
            }
        }
        return null;
    }

    // Phương thức tìm kiếm hóa đơn theo khách hàng
    public Bill findBillByCustomer(String maKH) {
        for (Bill bill : billList) {
            if (bill.getKhachHang().getMaKH().equals(maKH)) {
                return bill;
            }
        }
        return null;
    }

    // Phương thức tìm kiếm hóa đơn theo người tạo
    public Bill findBillByEmployee(String maNV) {
        for (Bill bill : billList) {
            if (bill.getNguoiLapHoaDon().getEmployeeId().equals(maNV)) {
                return bill;
            }
        }
        return null;
    }

    // Hàm lưu danh sách vào file
    public void saveToFile(String filePath) {
        int dem = 0;
        try {

            FileWriter writer = new FileWriter(filePath);

            // Duyệt qua danh sách hoa d on và ghi thông tin của từng hoa don vào file
            for (Bill b : billList) {
                String line = b.toString() + "\n";
                writer.write(line);
                dem++;
            }

            writer.close();
            System.out.println("Lưu danh sách hoa don vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lưu danh sách hoa don vào file thất bại.");
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

                // Tách thông tin từng thuộc tính của hoa don từ dòng đọc được
                String[] arr = line.split(",");

                // Lấy giá trị bên trái dấu bằng làm key, giá trị bên phải làm value
                Map<String, String> emoloyeeInfo = new HashMap<>();
                for (String s : arr) {
                    String[] temp = s.split("=");

                    if (temp.length >= 2) {
                        emoloyeeInfo.put(temp[0].trim(), temp[1].trim());
                    }
                }

                // Tạo đối tượng hoa don mới từ thông tin đã đọc được
                String maHD = emoloyeeInfo.get("maHoaDon");
                Customer cus = new Customer(emoloyeeInfo.get("khachHang"), "", "", "");
                Tour tour = new Tour(emoloyeeInfo.get("tour"), "", null, null, 0, 0, 0, null, null, false, "");
                int soLuongKhach = Integer.parseInt(emoloyeeInfo.get("soLuongKhach"));
                int giaTour = Integer.parseInt(emoloyeeInfo.get("giaTour"));
                LocalDate ngayLapHoaDon = LocalDate.parse(emoloyeeInfo.get("ngayLapHoaDon"));
                Employee nguoiLapHoaDon = new Employee(emoloyeeInfo.get("nguoiLapHoaDon"), "", "", "", "");

                Bill bill = new Bill(maHD, cus, tour, soLuongKhach, giaTour, ngayLapHoaDon, nguoiLapHoaDon);

                // Thêm hoa don mới vào danh sách nếu chưa tồn tại trong danh sách
                boolean isExisted = false;
                for (Bill b : billList) {
                    if (b.getMaHoaDon().equals(maHD)) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    billList.add(bill);
                }
            }

            scanner.close();
            System.out.println("Load danh sách hoa don từ file thành công.");
        } catch (FileNotFoundException e) {
            System.out.println("Load danh sách hoa don từ file thất bại: File không tồn tại.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Load danh sách hoa don từ file thất bại: Lỗi định dạng dữ liệu.");
            e.printStackTrace();
        }
    }

}
