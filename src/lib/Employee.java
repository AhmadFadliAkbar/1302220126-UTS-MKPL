package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;


public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;
    
    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan
    
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    
    private FamilyDetails family;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        
        family = new FamilyDetails();
    }
    
    // Set gaji bulanan berdasarkan grade
    public void setMonthlySalary(int grade) {    
        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary = (int) (monthlySalary * 1.5);
            }
        }
    }
    
    public void setAnnualDeductible(int deductible) {    
        this.annualDeductible = deductible;
    }
    
    public void setAdditionalIncome(int income) {    
        this.otherMonthlyIncome = income;
    }
    
    public void setSpouse(String spouseName, String spouseIdNumber) {
        family.setSpouse(spouseName, spouseIdNumber);
    }
    
    public void addChild(String childName, String childIdNumber) {
        family.addChild(childName, childIdNumber);
    }
    
    public int getAnnualIncomeTax() {
        // Hitung lama kerja dalam setahun
        LocalDate date = LocalDate.now();
        
        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }
        
        return TaxFunction.calculateTax(monthlySalary + otherMonthlyIncome, monthWorkingInYear, annualDeductible, family.hasSpouse(), family.getChildCount());
    }
}
