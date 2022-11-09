package infinite.payroll;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employ")
public class Employ {
	
	@Id
	@Column(name="empno")
	private int empno;
	
	@Column(name="empname")
	private String name;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="Hra")
	private double hra;
	
	@Column(name="Da")
	private double da;
	
	@Column(name="Ta")
	private double ta;
	
	@Column(name="Tax")
	private double tax;
	
	@Column(name="Pf")
	private double pf;
	
	@Column(name="Gross")
    private double gross;
	
	@Column(name="NetPay")
    private double netPay;
	
	@Column(name="LeaveAvailable")
    private int leaveAvail;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public int getLeaveAvail() {
		return leaveAvail;
	}

	public void setLeaveAvail(int leaveAvail) {
		this.leaveAvail = leaveAvail;
	}
	
	
}
