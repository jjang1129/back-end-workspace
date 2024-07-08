package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {

	// 이름으로 사람 찾기 
	
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		
	
	    	for (int i = 0;i < empArr.length; i++) {
	    		if( empArr[i].getName().equals(name)) {
	    			System.out.println(empArr[i]);	
	    			
	    		}     	
	    	}	 	
	    	return null;
	 
	    	
	}
	
	// 찾는 사람의 연봉은?
	public int getAnnualSalaray(Employee e) {
		
	   System.out.println(e.getSalary()*12);
			
		return 1;
	}
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee [] empArr) {
		
		
		int sum =0;
		for(int i = 0; i < empArr.length; i++) {
			sum+=(empArr[i].getSalary()*12);
		} 
		
		
		System.out.println(sum);
		return sum;
	}
	
}
