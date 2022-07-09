package interview.javaguides.todolist.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descrption", nullable = false)
	private String description;
	
	@Column(name = "log_date_upd")
	private Date logDateUpd;
	
	public Item() {
		
	}
	
	public Item(String description, Date logDateUpd) {
		super();
		this.description = description;
		this.logDateUpd = logDateUpd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLogDateUpd() {
		return logDateUpd;
	}

	public void setLogDateUpd(Date logDateUpd) {
		this.logDateUpd = logDateUpd;
	}
	
	@PreUpdate
	public void onpreupd() {
		this.logDateUpd = new Date();
	}
	
	@PrePersist
	public void onpreinsert() {
		this.logDateUpd = new Date();
	}
	
	
}
