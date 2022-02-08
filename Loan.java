package lab03;

import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

public class Loan {
    private double annualIntrestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate = new Date();

    public double getAnnualIntrestRate() {
        return annualIntrestRate;
    }
    public void setAnnualIntrestRate(double annualIntrestRate) {
        this.annualIntrestRate = annualIntrestRate;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    public double getLoanAmmount() {
        return loanAmount;
    }
    public void setLoanAmmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public Date getLoanDate() {
        return loanDate;
    }

    public Loan(double annualIntrestRate, int numberOfYears, double loanAmount) {
        this.annualIntrestRate = annualIntrestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        //this.loanDate = 
    }
    public Loan() {
    }

    public double getMonthlyPayment(){
        //double monthlyPayment = 0.0f;
        //monthlyPayment =  (this.loanAmount * (this.annualIntrestRate/12))/(1 - (1/ Math.pow((1+(this.annualIntrestRate/12)),(12*this.numberOfYears))));
        //return monthlyPayment;
            double monthlyInterestRate = (this.annualIntrestRate / 100) / 12;
            double loanXmonthly = this.loanAmount * monthlyInterestRate;
            double numYearsX = this.numberOfYears * 12;
            double monthlyPayment = loanXmonthly / (1 - (1 / (Math.pow((1 + monthlyInterestRate), numYearsX))));
            return monthlyPayment;
        
    }

    public double getTotalPayment(){
        return getMonthlyPayment() * this.numberOfYears * 12;
        //return 0.0f;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for interest: ");
        double interestRate  = input.nextDouble();

        System.out.print("Enter a number for years: ");
        int year  = input.nextInt();

        System.out.print("Enter a number for loan Amount: ");
        double lAmount  = input.nextDouble();
        
        Loan loan = new Loan(interestRate, year,lAmount );
        System.out.println("The loan was created " + loan.getLoanDate());
        System.out.printf("The loan monthly payment is %.2f\n" , loan.getMonthlyPayment());
        System.out.printf("The total payment is %.2f" , loan.getTotalPayment());
        input.close();
    }
}
