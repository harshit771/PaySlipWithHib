package infinite.payroll;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LeaveDetails")
public class LeaveDetails {

	@Id
	@Column(name="leaveID")
	private int leaveId;
	
	@Column(name="empno")
	private int empno;
	
	@Column(name="LeaveStartDate")
	private Date leaveStartDate;
	
	@Column(name="LeaveEndDate")
	private Date leaveEndDate;
	
	@Column(name="NoOfDays")
	private int noOfDays;
	
	@Column(name="LeaveReason")
	private String leaveReason;
	
	@Column(name="lossOfPay")
	private double lossOfPay;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public double getLossOfPay() {
		return lossOfPay;
	}

	public void setLossOfPay(double lossOfPay) {
		this.lossOfPay = lossOfPay;
	}
	
	
	
}
