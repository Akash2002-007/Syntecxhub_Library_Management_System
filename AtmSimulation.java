package com.atm.simulation;

import java.util.Scanner;

public class AtmSimulation {
        static class Account{
        	private int accountNumber;
        	private int pin;
        	private double balance;
        	
			public Account(int accountNumber, int pin, double balance) {
				super();
				this.accountNumber = accountNumber;
				this.pin = pin;
				this.balance = balance;
			}

			public int getAccountNumber() {
				return accountNumber;
			}

			public int getPin() {
				return pin;
			}

			public double getBalance() {
				return balance;
			}
			public void deposit(double amount) {
				balance=balance-amount;
			}
			public boolean withdraw(double amount) {
				if(amount<=balance) {
					balance=balance-amount;
					
					return true;
				}
				return false;
			}
			
        	static class User{
        		private Account account;
        		
        		public User(Account account) {
        			this.account=account;
        			
        		}
        		public Account getAccount() {
        			return account;
        		}
        	}
        	static class ATM{
        		private User user;
        		private  boolean loggedIn=false;
        		
        		Scanner sc=new Scanner(System.in);
        		
        		public ATM(User user) {
        			this.user=user;
        		}
        		
        		public void login() {
        			int attempts=0;
        			
        			while(attempts<3) {
        				System.out.println("Enter PIN:");
        				int enteredPin=sc.nextInt();
        				
        				if(enteredPin==user.getAccount().getPin()) {
        					loggedIn=true;
        					
        					System.out.println("Login successfull");
        					return ;
        					
        				}else {
        					attempts++;
        					System.out.println("Invalid  PIN");
        					
        					if(attempts<3) {
        						System.out.println("Remaining Attempts:"+(3-attempts));
        						
        					}
        				}
        			}
        			System.out.println("Account Locked!");
        		}
        		public void checkBalance() {
        			if(!loggedIn) {
        				System.out.println("Please login first.");
        				return;
        			}
        			System.out.println("Current Balance: Rup"+user.getAccount().getBalance());
        			
        		}
        		 public void deposit() {

        	            if (!loggedIn) {
        	                System.out.println("Please login first.");
        	                return;
        	            }

        	            System.out.print("Enter deposit amount: ");
        	            double amount = sc.nextDouble();

        	            if (amount > 0) {

        	                user.getAccount().deposit(amount);

        	                System.out.println(
        	                    "Amount deposited successfully."
        	                );

        	                System.out.println(
        	                    "Updated Balance: ₹"
        	                    + user.getAccount().getBalance()
        	                );

        	            } else {

        	                System.out.println("Invalid amount.");
        	            }
        	        }
        		 
        		 public void withdraw() {
        			 if(!loggedIn) {
        				 System.out.println("Please login first");
        				 return;
        			 }
        			 System.out.println("Enter the withdrawal amount:");
        			  double amount=sc.nextDouble();
        			  
        			  if(amount<=0) {
        				  System.out.println("Enter the invalid amount");
        				  return;
        				  
        			  }
        			  if(user.getAccount().withdraw(amount)) {
        				  System.out.println("please collect you cash.");
        			  
        			  System.out.println("Remaining Balance:Rup"+user.getAccount().getBalance());
        			 
        		 }else {
        			 System.out.println("Insufficient balance");
        			 
        		 }
        		 
        	}
        		 public void logout() {
        			 loggedIn=false;
        			 
        			 System.out.println("You have logged out");
        		 }
        		 
        		 public void stasrt() {
        			 login();
        			 
        			 if((!loggedIn)) {
        				 return;
        			 }
        			 int choice;
        			 
        			 do {
        				 System.out.println("====================");
        				 System.out.println("ATM MENU");
        				 System.out.println("=====================");
        				 
        				 System.out.println("1.Check Balance");
        				 System.out.println("2.Deposit");
        				 System.out.println("3.Withdraw");
        				 System.out.println("4.LogOut");
        				 
        				 System.out.println("Enter Your Choice");
        				 choice=sc.nextInt();
        				 
        				 switch(choice) {
        				 case 1:
        					    checkBalance();
        					    break;
        					    
        				 case 2:
     					        deposit();
     					    break;
     					    
        				 case 3:
     					    withdraw();
     					    break;
     					    
        				 case 4:
     					    logout();
     					    break;
        					    
        			  default:
        				  System.out.println("Invalid choice Please try again");
        				  
        				 
        				 }
        				 
        			 }while(loggedIn);
        			 
        		 }
        }
        	
        	public static void main(String[] args) {
        		Account account=new Account(1001,1234,10000);
        		
        		User user=new User(account);
        		
        		ATM atm=new ATM(user);
        		
        		atm.stasrt();
        		
        	}
        
        }
}
