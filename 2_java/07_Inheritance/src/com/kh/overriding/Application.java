package com.kh.overriding;

import java.util.Scanner;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {
     
	
	public static void main(String[] args) {
		
		Customer customer1 = new Customer("김경주");
		Customer customer2 = new Customer("김경주");
		 
          System.out.println(customer1);
          System.out.println(customer2);
          
          System.out.println(customer1 == customer2); // false 보여지는건 같지만 주소값이 다름 
          System.out.println(customer1.equals(customer2)); // false -> true 
          
          // ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다. 
                             
          System.out.println(customer1.getName()+"님의 등급은 "+customer1.getGrade()+"이며, 지불해야 하는 금액은"+
          customer1.calcPrice(10000)+"원이며, 적립된 포인트는 " + customer1.getBonusPoint()+"점입니다.");
          
          VIPCustomer customer3 = new VIPCustomer("김진주");
          VIPCustomer customer4 = new VIPCustomer("김진수");
          System.out.println(customer4);
          System.out.println(customer3.getName()+"님의 등급은 "+customer3.getGrade()+"이며, 지불해야 하는 금액은 "+
                  customer3.calcPrice(10000)+"원이며, "+"할인된 금액은 "+customer3.calcPrice1(10000)+"원이며, "+ "적립된 포인트는 " + customer3.getBonusPoint()+"점입니다.");
	}

}
