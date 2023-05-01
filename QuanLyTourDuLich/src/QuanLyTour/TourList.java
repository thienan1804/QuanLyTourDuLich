/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTour;

import java.util.Scanner;

/**
 *
 * @author thien
 */
public class TourList {

    public static Tour[] tour = new Tour[100];
    private int countTour;
    Scanner sc = new Scanner(System.in);

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
            }
            countTour++;
        }
    }

    public void updateTour(String maTour, Tour tourMoi) {
        for (int i = 0; i < countTour; i++) {
            if (tour[i].getMaTour().equals(maTour)) {
                tour[i] = tourMoi;
                System.out.println("Cap nhat thanh cong");
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
}
