package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {

	private Employee employee = new Employee();
	
	//1번을 눌렀을때 
	public void add(int empNo,String name,char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhon(phone);
		
	};
	// 1번을 누르고 추가 정보에서 Y를 눌렀을때 실행 
    public void add(int empNo,String name,char gender, String phone,String dept,int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhon(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	};
	// 2번을 눌렀을때 셋중에 하나 골라서 실행 
	public void modify(String phone) {
		employee.setPhon(phone);
	};
    public void modify(int salary) {
		
	};
	public void modify (double bonus) {
		
	}
	@Override
	public String toString() {
		return "EmployeeController [employee=" + employee + "]";
	};
	// 3번을 눌렀을때 실행 
//	public Employee info() {
		
//	};
	
	
}
