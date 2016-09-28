package com.farouk.bengharssallah.java.persistence.spring.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//annotation @Entity eliminates the need to write a hibernate mapping file like the way in hibernate core, Employee POJO
//represents now an entity mapped in database

@Entity
// related database table
@Table(name="EMPLOYEE")
public class Employee  implements Serializable{

            // a primary key column
      @Id
           // column name in associated table
      @Column(name="ID")
    private int id;
           // column name in associated table
      @Column(name="NAME")
    private String Name;
    
    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
	         
}