package com.nit.syntecxhub;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
        
	static ArrayList<Book>books=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("LIBRARY MANAGEMENT SYSTEM");
			System.out.println("1.ADD BOOK");
			System.out.println("2.Remove BOOK");
			System.out.println("3.SEARCH BOOK");
			System.out.println("4.DISPLAY ALL BOOK");
			System.out.println("5.EXIT");
			
			try {
				System.out.println("ENTER YOUR CHOICE:");
				int choice=sc.nextInt();
				    sc.hasNextLine();
				    
				    switch(choice) {
				    
				    case 1: 
				    	addBook();
				            break;
				      
				    case 2: 
				    	removeBook();
				             break;
				    case 3:
				    	 searchBook();
				    	 break;
				    case 4:
				    	 displayBook();
				    	 break;
				    case 5:
				    	 System.out.println("THANK YOU");
				    	 return;
				    	 
				    default:
				    	System.out.println("INVALID INPUT! ENTER 1 TO 5.");
				    }
			}catch(Exception e) {
				System.out.println("INVALID INPUT! PLEASE ENTER A NUMBER.");
				sc.nextLine();
			}
		}

	}
	static void addBook() {
		System.out.println("ENTER THE BOOK ID");
		int id=sc.nextInt();
		sc.nextLine();
		
		for(Book b: books) {
			if(b.id==id) {
				System.out.println("BOOK ID ALREADY EXISTS!");
				return;
			}
		}
		System.out.println("ENTER BOOK NAME:");
		String name=sc.nextLine();
		
		if(name.trim().isEmpty()) {
			System.out.println("BOOK NAME CAN NOT BE EMPTY");
			return;
		}
		System.out.println("ENTER AUTHER NAME:");
		String author=sc.nextLine();
		
		if(author.trim().isEmpty()) {
			System.out.println("AUTHOR NAME CAN NOT BE EMPTY");
			return;
		}
		Book b=new Book(id,name,author);
		books.add(b);
		
		System.out.println("BOOK ADDES SUCCESSFULLY");
	}
    static void removeBook() {
    	  System.out.println("ENTER BOOK ID TO REMOVE");
    	  int id=sc.nextInt();
    	  
    	  for(int i=0;i<books.size();i++) {
    		  if(books.get(i).id==id) {
    			  books.remove(i);
    			  System.out.println("BOOK REMOVE SUCCESSFULLY");
    			  return;
    		  }
    	  }
    	  System.out.println("BOOK NOT FOUND");
    }
    
    static void searchBook() {
    	System.out.println("ENTER BOOK ID TO SEARCH:");
    	int id=sc.nextInt();
    	
    	for(Book b:books) {
    		if(b.id==id) {
    			System.out.println("BOOK FOUND");
    			
    			System.out.println("ID :"+b.id);
    			System.out.println("NAME:"+b.name);
    			System.out.println("Author:"+b.author);
    			return;
    		}
    	}
    	System.out.println("BOOK NOT FOUND");
    }
    
    static void displayBook() {
    	if(books.isEmpty()) {
    		System.out.println("NO BOOK AVAILABLE.");
    		 return;
    		 
    	}
    	System.out.println("ALL BOOKS");
    	
    	for(Book b:books) {
    		System.out.println("ID:"+b.id);
    		System.out.println("Name:"+b.name);
    		System.out.println("Author:"+b.author);
    		System.out.println("------------------");
    	}
    }
}
