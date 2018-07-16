package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.*;

import com.cg.mypaymentapp.beans.*;
import com.cg.mypaymentapp.service.*;

public class Client 
{
	   public static void main( String[] args )  
	   {
		  	   
		   WalletService service;
		   {
			   service=new WalletServiceImpl();
		   }
		   
		   
		   Scanner scan=new Scanner(System.in);
		   int choice;
		   do 
		   {
		   System.out.println("My Payment App\n______________\n1.Create Account\n2.Show Balance\n3.Fund Transfer\n4.Deposit Amount\n5.Withdraw Amount\n6.Exit");
		   choice=scan.nextInt();
		   switch(choice)
		   {
		   
		   case 1:
			   		Customer customer=null;
			   		String name ,mobileNo;
			   		BigDecimal amount;
			   		
			   		System.out.println("Enter Name: ");
			   		name=scan.next();
			   		System.out.println("Enter Mobile Number: ");
			   		mobileNo=scan.next();
			   		System.out.println("Enter Amount: ");
			   		amount=scan.nextBigDecimal();
			   		try
			   		{
			   		customer=service.createAccount(name,mobileNo,amount);
			   		}
			   		catch (Exception e) 
			   		{
			   			System.err.println(e.getMessage());
					}
			   		if(customer!=null)
		   			{
		   			System.out.println("\n"+customer);
		   			System.out.println("Account created succesfully\n");
		   			}
			   		
			   		
			   		break;
			   		
			   		
		   case 2:
			   		System.out.println("Enter mobile number: ");
			   		mobileNo=scan.next();
			   		try {
			   			customer=service.showBalance(mobileNo);
			   			System.out.println(customer);
			   			} 
			   		catch (Exception e) {
			   			System.err.println(e.getMessage());
			   			} 

			   		
		   			break;
		   			
		   			
		   			
		   case 3:	
			   		String sourceNo,targetNo;
			   		System.out.println("Enter SourceMobile Number: ");
			   		sourceNo=scan.next();
			   		System.out.println("Enter TargetMobile Number: ");
			   		targetNo=scan.next();
			   		System.out.println("Enter transfer amount: ");
			   		amount=scan.nextBigDecimal();
			   		try {
			   			customer=service.fundTransfer(sourceNo, targetNo, amount);
			   			System.out.println(customer);
			   			}	
			   		catch (Exception e) 
			   			{
			   			System.err.println(e.getMessage());
			   			}
			   		
		   			break;
		   			
		   case 4:
			   		System.out.println("Enter mobile number: ");
			   		mobileNo=scan.next();
			   		System.out.println("Enter deposit amount: ");
			   		amount=scan.nextBigDecimal();
			   		try 
			   		{
			   			customer=service.depositAmount(mobileNo, amount);
			   			System.out.println(customer);
			   		} 
			   		catch (Exception e) 
			   		{
			   			System.err.println(e.getMessage());
			   		}
			   		
			   		break;
		   case 5:
			   		System.out.println("Enter mobile number: ");
			   		mobileNo=scan.next();
			   		System.out.println("Enter withdrawal amount: ");
			   		amount=scan.nextBigDecimal();
			   		try
			   		{
			   			customer=service.withdrawAmount(mobileNo, amount);
			   			System.out.println(customer);
			   		}
			   		catch (Exception e) 
			   		{
			   			System.err.println(e.getMessage());
			   		}
			   		
		   			break;
		   case	6:
			   		
			   		System.out.println("\nSuccesfully exited!");
			   		break;
			   		
		   default:
			   		System.out.println("\n**Enter choices from 1-6 only**\n");
			   		break;
		   
		   }
		   
		   }while(choice!=6);
		   scan.close();
	   }
}
