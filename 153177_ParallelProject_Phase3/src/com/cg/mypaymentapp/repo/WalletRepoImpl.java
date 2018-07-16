package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
;

public class WalletRepoImpl implements WalletRepo{

	//private Map<String, Customer> data; 
	
	public WalletRepoImpl(Map<String, Customer> data) 
	{
		super();
		//this.data = data;
		
		
		
		
	}

	public boolean save(Customer customer) throws Exception 
	{
		if(findOne(customer.getMobileNo())==null)
		{
		/*try{	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","corp123");
			String sql="insert into Customer values(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,customer.getMobileNo());
			stmt.setString(2,customer.getName());
			stmt.setInt(3,customer.getWallet().getBalance().intValueExact());
			stmt.executeUpdate();
			con.close();
		return true;}
		catch(Exception e)
		{
			return false;
			
		}*/
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("153177_ParallelProject_Phase3");
			EntityManager em=emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(customer);
			tx.commit();
			em.close();
			return true;
		}
		
		else
		{
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","corp123");
			String sql="update  Customer set amount= ? "+"where mobilenumber= ? "+";";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,customer.getWallet().getBalance().intValueExact() );
			stmt.setString(2,customer.getMobileNo());
			stmt.executeUpdate();
			con.close();*/
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("153177_ParallelProject_Phase3");
			EntityManager em=emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.merge(customer);
			tx.commit();
			em.close();
			return true;
		}
	}
	
	

	public Customer findOne(String mobileNo) 
	{
		
		/*try
		{	Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","corp123");
		String sql="select * from Customer where mobilenumber="+mobileNo+";";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Customer c=null;
		while(rs.next())
		{c=new Customer(rs.getString(2),rs.getString(1),new Wallet(new BigDecimal(rs.getInt(3))));
		}
		return c;
		}
		catch(Exception e)
		{
			return null;
		}
	}*/EntityManagerFactory emf=Persistence.createEntityManagerFactory("153177_ParallelProject_Phase3");
	EntityManager em=emf.createEntityManager();
	Customer c=em.find(Customer.class,mobileNo);
	return c;
	
}
}
