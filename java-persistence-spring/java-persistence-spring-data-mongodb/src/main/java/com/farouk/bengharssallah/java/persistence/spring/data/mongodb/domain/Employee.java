package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

   // noSQL databases is different from relational databases, schema should not be respected, 
   // provide all attributes in json file [equal to sql file in relational schema]; they 
   // can be skipped. The databases contains a group of collections[equal to table in relational 
   // schema], and a collection contains a list of documents [equal to entity in relational 
   // schema]
@Document
public class Employee {


	@Id
	private int id;
	private String reference;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}