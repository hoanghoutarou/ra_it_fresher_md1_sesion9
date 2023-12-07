package ra.presentation;

import ra.businessImp.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    Employee[] arrEmp = new Employee[100];
    int index = 0;
    private List<Employee> employeeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManagement objMain = new EmployeeManagement();
        do {
            System.out.println("********************MENU*********************\n" +
                    "1. Nhập thông tin cho n nhân viên\n" +
                    "2. Hiển thị thông tin nhân viên\n" +
                    "3. Tính lương cho các nhân viên\n" +
                    "4. Tìm kiếm nhân viên theo tên nhân viên\n" +
                    "5. Cập nhật thông tin nhân viên\n" +
                    "6. Xóa nhân viên theo mã nhân viên\n" +
                    "7. Sắp xếp nhân viên theo lương tăng dần (Comparable)\n" +
                    "8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)\n" +
                    "9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)\n" +
                    "10. Thoát\n");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    objMain.input(sc);
                    break;
                case 2:
                    objMain.display();
                    break;
                case 3:
                    objMain.calSalary();
                    break;
                case 4:
                    objMain.find(sc);
                    break;
                case 5:
                    objMain.update(sc);
                    break;
                case 6:
                    objMain.delete(sc);
                    break;
                case 7:
                    objMain.sortEmployeesSalary();
                    break;
                case 8:
                    objMain.sortEmployeesByNameDescending();
                    break;
                case 9:
                    objMain.sortEmployeesByBirthYearAscending();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Hay lua chon tu 1en 10");
            }
        } while (true);


    }

    public void sortEmployeesByBirthYearAscending() {
        Collections.sort(employeeList, Comparator.comparingInt(Employee::getYear));
    }

    public void sortEmployeesByNameDescending() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
    }

    public void sortEmployeesSalary() {
        System.out.println("Sắp xếp tbeo lương nhân  viên tăng dần");
        Collections.sort(employeeList, Comparator.comparing(Employee::getSalary));
    }



    public void delete(Scanner sc) {
        System.out.println("Nhập vào mã nhan vien cần xóa:");
        String empIdDelete = sc.nextLine();
        int indexDelete = getIndexById(empIdDelete);
        if (indexDelete >= 0) {
            //Tiến hành xóa
            for (int i = indexDelete; i < index; i++) {
                arrEmp[i] = arrEmp[i + 1];
            }
            arrEmp[index - 1] = null;
            index--;
            System.out.println("xoa thanh cong");
        } else {
            System.err.println("Mã nhan vien không tồn tại");
        }
    }

    public int getIndexById(String Id) {
        for (int i = 0; i < index; i++) {
            if (arrEmp[i].getId() == Id) {
                return i;
            }
        }
        return -1;
    }

    public void update(Scanner sc) {
        System.out.println("Nhập mã danh nhan vien cần cập nhật:");
        String Id = sc.nextLine();
        int indexUpdate = getIndexById(Id);
        if (indexUpdate >= 0) {
            //Tồn tại
            arrEmp[indexUpdate].updateEmp(sc, arrEmp, index, indexUpdate);
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public void find(Scanner sc) {
        System.out.println("Nhap ten nhan vien can tim:");
        String name = sc.nextLine();
        System.out.println("THÔNG TIN CÁC NHAN VIEN:");
        for (int i = 0; i < index; i++) {
            if (arrEmp[i].getName().equals(name))
                arrEmp[i].displayData();
        }
    }

    public void calSalary() {
        for (int i = 0; i < index; i++) {
            System.out.printf("Luong cua nhan vien %s:", arrEmp[i].getName());
            arrEmp[i].calSalary();
        }
    }

    public void input(Scanner sc) {
        System.out.println("Nhập vào số luong nhan vien:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arrEmp[index] = new Employee();
            arrEmp[index].inputData(sc);
            index++;
        }
    }

    public void display() {
        System.out.println("THÔNG TIN CÁC NHAN VIEN:");
        for (int i = 0; i < index; i++) {
            arrEmp[i].displayData();
        }
    }

}
