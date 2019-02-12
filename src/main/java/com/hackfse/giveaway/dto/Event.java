package com.hackfse.giveaway.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "Event")
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Date created_at;
	private Date updated_at;
	private Date startDate;
	private Date endDate;
	private String address;
	private String city;
	private String contactno;
	private String contactName;
	private String pic_url_1;
	private String pic_url_2;
	private String pic_url_3;
	private String pic_url_4;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getPic_url_1() {
		return pic_url_1;
	}
	public void setPic_url_1(String pic_url_1) {
		this.pic_url_1 = pic_url_1;
	}
	public String getPic_url_2() {
		return pic_url_2;
	}
	public void setPic_url_2(String pic_url_2) {
		this.pic_url_2 = pic_url_2;
	}
	public String getPic_url_3() {
		return pic_url_3;
	}
	public void setPic_url_3(String pic_url_3) {
		this.pic_url_3 = pic_url_3;
	}
	public String getPic_url_4() {
		return pic_url_4;
	}
	public void setPic_url_4(String pic_url_4) {
		this.pic_url_4 = pic_url_4;
	}
	
	
	public Event(Long id, String name, Date created_at, Date updated_at, Date startDate, Date endDate, String address,
			String city, String contactno, String contactName, String pic_url_1, String pic_url_2, String pic_url_3,
			String pic_url_4) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.city = city;
		this.contactno = contactno;
		this.contactName = contactName;
		this.pic_url_1 = pic_url_1;
		this.pic_url_2 = pic_url_2;
		this.pic_url_3 = pic_url_3;
		this.pic_url_4 = pic_url_4;
	}
	public Event() {
		super();
	}
	
	
}
