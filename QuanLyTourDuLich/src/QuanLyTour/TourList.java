/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyKhachHang.Customer;
import static QuanLyKhachHang.CustomerList.customerList;
import QuanLyNhanVIen.Employee;
import QuanLyNhanVIen.EmployeeList;
import static QuanLyTour.TourManagement.linkFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thien
 */
public class TourList {

    public static Tour[] tour = new Tour[100];
    private int countTour;
    Scanner sc = new Scanner(System.in);
    Employee nguoiTao;

    public void TourList() {
        countTour = 0;
        for (int i = 0; i < 100; i++) {
            tour[i] = new Tour();
        }
    }

    public boolean isTourCodeExist(String tourCode) {
        for (int i = 0; i < countTour; i++) {
            if (tour[i].getMaTour().equals(tourCode)) {
                return true;
            }
        }
        return false;
    }

    public void addTourList(int choice) {
        if (countTour > 100) {
            System.out.println("Du lieu da day");
        } else {
            boolean isExist;
            if (choice == 1) {
                tour[countTour] = new BeachTour();
                BeachTour beach = new BeachTour();
                do {
                    System.out.println("Nhap ma tour: ");
                    beach.maTour = sc.nextLine();
                    isExist = isTourCodeExist(beach.maTour);
                    if (isExist) {
                        System.out.println("Mã tour đã tồn tại, vui lòng nhập lại!");
                    }
                } while (isExist);
                beach.nhap();
                tour[countTour] = beach;
                saveToFile(linkFile);
            } else {
                tour[countTour] = new CityTour();
                CityTour city = new CityTour();
                do {
                    System.out.println("Nhap ma tour: ");
                    city.maTour = sc.nextLine();
                    isExist = isTourCodeExist(city.maTour);
                    if (isExist) {
                        System.out.println("Mã tour đã tồn tại, vui lòng nhập lại!");
                    }
                } while (isExist);
                city.nhap();
                tour[countTour] = city;
                saveToFile(linkFile);
            }
            countTour++;
        }
    }

    public void updateTour(String maTour, Tour tourMoi) {
        for (int i = 0; i < countTour; i++) {
            if (tour[i].getMaTour().equals(maTour)) {
                tour[i] = tourMoi;
                System.out.println("Cap nhat thanh cong");
                saveToFile(linkFile);
                return;
            }
        }
        System.out.println("Khong tim thay ma tour " + maTour);
    }

    public void deleteTour(String maTour) {
        boolean found = false;
        for (int i = 0; i < countTour; i++) {
            if (found) {
                tour[i - 1] = tour[i];
            } else if (tour[i].getMaTour().equals(maTour)) {
                found = true;
            }
        }
        if (found) {
            countTour--;
            System.out.println("Xoa thanh cong!");
            saveToFile(linkFile);
        } else {
            System.out.println("Xoa that bai!");
        }
    }

    public void xuat() {
        for (int i = 0; i < countTour; i++) {
            System.out.println("STT: " + i);
            System.out.println(tour[i].toString());
        }
    }

    public Tour findTourByName(String tenTour) {
        for (int i = 0; i < countTour; i++) {
            if (tour[i].getTenTour().equals(tenTour)) {
                return tour[i];
            }
        }
        return null;
    }

    public void saveToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            // Duyệt qua danh sách tour và ghi thông tin của từng tour vào file
            for (Tour t : tour) {
                if (t != null) {
                    String line = t.toString() + "\n";
                    writer.write(line);
                }
            }

            writer.close();
            System.out.println("Lưu danh sách tour vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lưu danh sách tour vào file thất bại.");
            e.printStackTrace();
        }
    }

    // Ham lay du lieu tu file
    public void loadFromFile(String tenFile) {

        try {
            Scanner scanner = new Scanner(new File(tenFile));
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] tourInfo = new String[13];
                String[] parts = line.split(": ");
                tourInfo[0] = parts[0]; // "BeachTour" hoặc "CityTour"

                Pattern pattern = Pattern.compile("(\\w+)=(\\S+)");
                Matcher matcher = pattern.matcher(parts[1]);

                while (matcher.find()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    switch (key) {
                        case "maTour":
                            tourInfo[1] = value; // "t1"
                            break;
                        case "tenTour":
                            tourInfo[2] = value; // "nhatr"
                            break;
                        case "ngayDi":
                            tourInfo[3] = value; // "02/05/2023"
                            break;
                        case "ngayVe":
                            tourInfo[4] = value; // "02/05/2023"
                            break;
                        case "giaTien":
                            tourInfo[5] = value; // "10.0tr"
                            break;
                        case "soLuongKhachToiDa":
                            tourInfo[6] = value; // "100"
                            break;
                        case "nguoiTao":
                            tourInfo[7] = value; // "nv1"
                            break;
                        case "trangThai":
                            tourInfo[8] = value; // "Dang mo ban"
                            break;
                        case "dsKhachHang":
                            String[] khachHangs = value.substring(1, value.length() - 1).split(",");
                            String khachHangList = "";
                            for (String khachHang : khachHangs) {
                                khachHangList += khachHang.trim() + " ";
                            }
                            tourInfo[9] = khachHangList; // "kh3 kh4"
                            break;
                        case "ghiChu":
                            tourInfo[10] = value; // "ko"
                            break;
                        case "tenBien":
                            tourInfo[11] = value; // "nhtrang"
                            break;
                        case "tenKhachSan":
                            tourInfo[12] = value; // "anthien"
                            break;
                    }
                }
                if (tourInfo[0].equals("BeachTour")) {
//                    BeachTour beach = new BeachTour();
//                    beach.maTour = tourInfo[1];
//                    beach.tenTour = tourInfo[2];
//                    beach.ngayDi = LocalDate.parse(tourInfo[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                    beach.ngayVe = LocalDate.parse(tourInfo[4], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                    beach.giaTien = Integer.parseInt(tourInfo[5]);
//                    beach.soLuongKhachToiDa = Integer.parseInt(tourInfo[6]);
//                    beach.nguoiTao = new Employee(tourInfo[7],"","","","");
//                    beach.trangThai=Boolean.parseBoolean(tourInfo[8]);
//                    beach.dsKhachHang = tourInfo[9];
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
