/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import QuanLyKhachHang.Customer;
import QuanLyNhanVIen.Employee;
import static QuanLyTour.TourManagement.linkFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] tourInfo = new String[15];
                String[] parts = line.split(": ");
                if (parts.length > 1) {
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
                            case "thanhTien":
                                tourInfo[14] = value;
                            case "giaTien":
                                tourInfo[5] = value; // "10.0tr"
                                break;
                            case "soLuongKhach":
                                tourInfo[6] = value; // "100"
                                break;
                            case "nguoiTao":
                                tourInfo[7] = value; // "ng tao"
                                break;
                            case "trangThai":
                                tourInfo[8] = value; // "trang thai"
                                break;
                            case "khachHang":
                                tourInfo[9] = value; // "kh1"
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
                            case "tenThanhPho":
                                tourInfo[13] = value; // "Bien Hoa"
                        }
                    }

                    if (tourInfo[0].equals("BeachTour")) {
                        BeachTour beach = new BeachTour();
                        beach.maTour = tourInfo[1].replaceAll(",", "");
                        beach.tenTour = tourInfo[2].replaceAll(",", "");
                        beach.ngayDi = LocalDate.parse(tourInfo[3].replaceAll(",", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        beach.ngayVe = LocalDate.parse(tourInfo[4].replaceAll(",", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        String giaTienStr = tourInfo[5].replaceAll("tr", "").replaceAll(",", ""); // Xóa "tr" và "," khỏi chuỗi giá tiền
                        beach.giaTien = (double) (Double.parseDouble(giaTienStr)); // Chuyển đổi sang số nguyên
                        String thanhTienStr = tourInfo[5].replaceAll("tr", "").replaceAll(",", ""); // Xóa "tr" và "," khỏi chuỗi giá tiền
                        beach.giaTienDuocGiam = (double) (Double.parseDouble(thanhTienStr)); // Chuyển đổi sang số nguyên
                        beach.soLuongKhach = Integer.parseInt(tourInfo[6].replaceAll(",", ""));
                        beach.nguoiTao = new Employee(tourInfo[7].replaceAll(",", ""), "", "", "", "");
                        beach.trangThai = Boolean.parseBoolean(tourInfo[8].replaceAll(",", ""));
                        beach.khachHang = new Customer(tourInfo[9].replaceAll(",", ""), "", "", "");
                        beach.ghiChu = tourInfo[10].replaceAll(",", "");
                        beach.tenBien = tourInfo[11].replaceAll(",", "");
                        beach.tenKhachSan = tourInfo[12].replaceAll(",", "");
                        tour[countTour++] = beach;
                    } else if (tourInfo[0].equals("CityTour")) {
                        CityTour city = new CityTour();
                        city.maTour = tourInfo[1].replaceAll(",", "");
                        city.tenTour = tourInfo[2].replaceAll(",", "");
                        city.ngayDi = LocalDate.parse(tourInfo[3].replaceAll(",", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        city.ngayVe = LocalDate.parse(tourInfo[4].replaceAll(",", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        String giaTienStr = tourInfo[5].replaceAll("tr", "").replaceAll(",", ""); // Xóa "tr" và "," khỏi chuỗi giá tiền
                        city.giaTien = (double) (Double.parseDouble(giaTienStr)); // Chuyển đổi sang số nguyên
                        city.soLuongKhach = Integer.parseInt(tourInfo[6].replaceAll(",", ""));
                        city.nguoiTao = new Employee(tourInfo[7].replaceAll(",", ""), "", "", "", "");
                        city.trangThai = Boolean.parseBoolean(tourInfo[8].replaceAll(",", ""));
                        city.khachHang = new Customer(tourInfo[9].replaceAll(",", ""), "", "", "");
                        city.ghiChu = tourInfo[10].replaceAll(",", "");
                        city.tenThanhPho = tourInfo[13].replaceAll(",", "");
                        tour[countTour++] = city;
                    }
                }
            }
            scanner.close();
            System.out.println("Load danh sách khách hàng từ file thành công.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Load danh sách tour từ file thất bại: File không tồn tại.");
        } catch (Exception e) {
            System.out.println("Load danh sách tour từ file thất bại: Lỗi định dạng dữ liệu.");
            e.printStackTrace();
        }
    }
}
