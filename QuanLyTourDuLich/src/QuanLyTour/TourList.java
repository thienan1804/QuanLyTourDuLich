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

    protected int MAX_SIZE = 100;
    protected Tour[] tour = new Tour[MAX_SIZE];
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
        if (countTour > MAX_SIZE) {
            System.out.println("Du lieu da day");
        } else {

            String tourCode;
            boolean isExist;
            do {
                System.out.print("Mã tour: ");
                tourCode = sc.nextLine();
                isExist = isTourCodeExist(tourCode);
                if (isExist) {
                    System.out.println("Mã tour đã tồn tại, vui lòng nhập lại!");
                }
            } while (isExist);
            if (choice == 1) {
                tour[countTour] = new BeachTour();
                BeachTour beach = new BeachTour();
                beach.nhap();
                tour[countTour] = beach;
            } else {
                tour[countTour] = new CityTour();
                CityTour city = new CityTour();
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
        }else {
            System.out.println("Xoa that bai!");
        }
    }
    
    public void xuat(){
        for(int i=0 ; i<countTour; i++){
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
