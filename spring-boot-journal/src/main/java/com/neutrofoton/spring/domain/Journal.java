package com.neutrofoton.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@SuppressWarnings("unused")
@Entity
public class Journal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String title;
	private Date created;
	private String summary;

	//@Transient annotation, which will indicate to the JPA engine not to persist that property
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Journal() {
	}
	
	public Journal(String title, String summary, String date) throws ParseException {
		this.setTitle(title);
		this.setSummary(summary);
		this.setCreated(format.parse(date));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getCreatedAsShort() {
		return format.format(created);
	}
	
	@Override
	public String toString() {
		
		String value = new StringBuilder()
				.append("JournalEntity(").append(System.lineSeparator())
				.append("Id: ").append(id).append(",").append(System.lineSeparator())
				.append("Title: ").append(title).append(",").append(System.lineSeparator())
				.append("Summary: ").append(summary).append(",").append(System.lineSeparator())
				.append("Created: ").append(getCreatedAsShort()).append(System.lineSeparator())
				.append(")")
				.toString();
		
		return value;
	}
}
