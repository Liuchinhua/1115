package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
//@Table(name="student") //如果class的名字跟資料庫欄位一樣，可以不用加這一行
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	
	@Id
	private int sid; //Primary Key

	private int age;

	private String sname;

	public Student() {
	}
	
	public Student(int id ,String n , int a) {
    	sid=id;
    	sname=n;
    	age=a;
    }
	
	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}