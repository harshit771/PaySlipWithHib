package infinite.payroll;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployDAO {
      SessionFactory sFactory;
      Session session;
      
      
      public String addEmploy(Employ employ) {
    	  sFactory=SessionHelper.getConnection();
    	  session=sFactory.openSession();
    	 double sal= employ.getSalary();
    	 double hra=sal*0.02;
    	 double da=sal*0.0125;
    	 double ta=sal*0.0095;
    	 double tax=sal*0.023;
    	 double pf=sal*0.03;
    	 double gross=sal+hra+da+ta;
    	 double netPay=gross-tax-pf;
    	 
    	 employ.setHra(hra);
    	 employ.setDa(da);
    	 employ.setTa(ta);
    	 employ.setTax(tax);
    	 employ.setPf(pf);
    	 employ.setNetPay(netPay);
    	 employ.setGross(gross);
    	 employ.setLeaveAvail(16);
    	  Transaction tr=session.beginTransaction();
    	  
    	  session.save(employ);
    	  tr.commit();
    	  return "Record Added";
      }
}
