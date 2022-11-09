package infinite.payroll;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class LeaveDetailsDAO {

	SessionFactory sFactory;
	Session session;
	
	public Date convertDate(java.util.Date d) {
		Date sqlDate=new Date(d.getTime());
//		System.out.println();
//		System.out.println(sqlDate);
		return sqlDate;
	}
	public LeaveDetails searchId(int empId) {
		sFactory = SessionHelper.getConnection();
  		Session session = sFactory.openSession(); 
  		Criteria cr = session.createCriteria(LeaveDetails.class);
  		cr.add(Restrictions.eq("empno", empId));
  		List<LeaveDetails> empList = cr.list();
  		return empList.get(0);
	}
	
	public int noOfDays(Date leaveEndDate,Date leaveStartDate) {
		int days = 0;
        
//		int month=leaveEndDate.getMonth();
//		int year=leaveEndDate.getYear();
//		int month2=leaveStartDate.getMonth();
//		if(month==month2) {
		 days=(int)((leaveEndDate.getTime()-leaveStartDate.getTime())/(1000*60*60*24));
		days++;
//		else {
//			
//			int day1=(int)(leaveEndDate.getTime());
//			int day2=(int)(leaveStartDate.getTime());
//		}
		return days;
	}
	public double lossPay(int empno,int month) {
		LeaveDetails leave=new LeaveDetails();
		
		
		Employ employ =new Employ();
	       
        employ=searchById(empno);
	double sal=	employ.getSalary();
	double s=sal/30.46,lpay = 0;long d;
		sFactory = SessionHelper.getConnection();
  		Session session = sFactory.openSession(); 
  		
		Query query=session.createQuery("select sum(noOfDays) from LeaveDetails where empno=:empno AND (MONTH(leaveStartDate)=:month AND "
				+ "MONTH(leaveEndDate)=:month)")
  				.setParameter("empno", empno).setParameter("month",month);

  	//	Query query=session.createQuery("select sum(noOfDays) from LeaveDetails where empno=:empno AND ((month+1)=:month AND (month2+1)=:month)")
  		//		.setParameter("empno", empno).setParameter("month", Integer.parseInt(month)).setParameter("month",Integer.parseInt(month));
  		List<Long> count=query.list();
  		//return count.get(0);
  	long x = (Long)count.get(0);
		if(x>=3) {
			d=x-3;
			lpay=d*s;
		}
		leave=searchId(empno);
		leave.setLossOfPay(lpay);
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(leave);
		tr.commit();
		return lpay;
		
	}
//	private double lossOfPay(int noOfDay,double sal) {
//		double s=sal/30.46,lpay = 0;
//		int d;
//		if(noOfDay > 3) {
//			d=noOfDay-3;
//			lpay=d*s;
//		}
//		return lpay;
//	}
//	
	public Employ searchById(int empId) {
		sFactory = SessionHelper.getConnection();
  		Session session = sFactory.openSession(); 
  		Criteria cr = session.createCriteria(Employ.class);
  		cr.add(Restrictions.eq("empno", empId));
  		List<Employ> empList = cr.list();
  		return empList.get(0);
	}
	public String addLeave(LeaveDetails leave) {
		sFactory=SessionHelper.getConnection();
		session=sFactory.openSession();
		Transaction tr=session.beginTransaction();
        Employ employ =new Employ();
       
        employ=searchById(leave.getEmpno());
        double sal=employ.getSalary();
//       System.out.println(sal);
        long ms = leave.getLeaveEndDate().getTime()-leave.getLeaveStartDate().getTime();
//        System.out.println(ms);
       
		int noOfDays=noOfDays(leave.getLeaveEndDate(),leave.getLeaveStartDate());
//		System.out.println(noOfDays);
		leave.setNoOfDays(noOfDays);
		
//		double lossPay=lossOfPay(noOfDays,sal);
//		leave.setLossOfPay(lossPay);
		session.save(leave);
		tr.commit();
		session.close();
		 
		employ=searchById(leave.getEmpno());
		if(noOfDays<=3) {
		employ.setLeaveAvail(employ.getLeaveAvail()-noOfDays);}
		else {
			employ.setLeaveAvail(employ.getLeaveAvail()-3);
		}
		session=sFactory.openSession();
	 tr=session.beginTransaction();
	session.saveOrUpdate(employ);
		tr.commit();
		
		return "Leave Applied";
	}
}
