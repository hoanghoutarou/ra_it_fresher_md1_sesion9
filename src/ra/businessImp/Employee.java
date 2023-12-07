package ra.businessImp;

import ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String Id, Name;
    private int Year;
    private Float Rate, Commission, Salary;
    private Boolean Status;

    public Employee() {
    }

    public Employee(String id, String name, int year, Float rate, Float commission, Float salary, Boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public Float getRate() {
        return Rate;
    }

    public void setRate(Float rate) {
        Rate = rate;
    }

    public Float getCommission() {
        return Commission;
    }

    public void setCommission(Float commission) {
        Commission = commission;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float salary) {
        Salary = salary;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public void inputData(Scanner sc) {
        System.out.println("Nhap ma nhan vien:");
        this.Id = sc.nextLine();
        System.out.println("Nhap ten nhan vien:");
        this.Name = sc.nextLine();
        System.out.println("Nhap nam sinh nhan vien:");
        this.Year = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap he so luong");
        this.Rate = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap hoa hong hang thang:");
        this.Commission = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap trang thai:");
        this.Status = inputStatus(sc);
    }

    public boolean inputStatus(Scanner sc) {
        System.out.println("Nhập vào trạng thái danh mục:");
        do {
            String status = sc.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận true hoặc false, vui lòng nhập lại");
            }
        } while (true);
    }
    public void calSalary(){
        this.Salary = this.Rate * BASIC_SALARY + this.Commission;
        System.out.println(this.Salary);
    }
    public void displayData() {
        System.out.printf("Ma nhan vien: %s - Ten nhan vien: %s \n Nam sinh: %d - He so luong: %2f \n Hoa hong: %2f - Luong hang thang: %2f \n Trang thai: %s",
                this.Id, this.Name, this.Year, this.Rate, this.Commission,this.Salary,this.Status ? "dang lam viec" : "nghi viec");
    }

    public void updateEmp(Scanner sc, Employee[] arrEmp, int index, int indexUpdate) {
        boolean isExit = true;
        do {
            System.out.println("1. Cập nhật tên nhan vien");
            System.out.println("2. Cập nhật nam sinh");
            System.out.println("3. Cập nhật he so luong");
            System.out.println("4. Cập nhật hoa hong");
            System.out.println("5. Cập nhật trang thai");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhap ten moi:");
                    this.Name = sc.nextLine();
                    System.out.println("Cap nhat ten thanh cong");
                    break;
                case 2:
                    System.out.println("Nhap nam sinh moi");
                    this.Year=Integer.parseInt(sc.nextLine());
                    System.out.println("Cap nhat nam sinh thanh cong");
                    break;
                case 3:
                    System.out.println("Nhap he so luong moi");
                    this.Rate = Float.parseFloat(sc.nextLine());
                    calSalary();
                    System.out.println("Cap nhat he so luong thanh cong");
                    break;
                case 4:
                    System.out.println("Nhap hoa hong");
                    this.Commission = Float.parseFloat(sc.nextLine());
                    calSalary();
                    System.out.println("Cap nhat hoa hong thanh cong");
                    break;
                case 5:
                    System.out.println("Nhap trang thai");
                    this.Status = inputStatus(sc);
                    System.out.println("Cap nhat trang thai thanh cong");
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("Nhap lua chon tu 1 den 6");
            }
        } while (isExit);
    }

}
