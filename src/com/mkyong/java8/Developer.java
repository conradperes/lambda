package com.mkyong.java8;

import java.math.BigDecimal;

public class Developer {
	private String nome;
	private BigDecimal salary;
	private int age;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Developer(String nome, BigDecimal salary, int age) {
		super();
		this.nome = nome;
		this.salary = salary;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Developer [nome=" + nome + ", salary=" + salary + ", age=" + age + "]";
	}
	
	
	


}
