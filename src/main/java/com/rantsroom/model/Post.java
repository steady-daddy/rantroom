package com.rantsroom.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "posts")
public class Post extends AuditModel {	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@NotNull
    @Size(max = 100)
    private String title;	
	@NotNull
    @Lob
	private String rant;	
	private boolean deleted;

    @OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
    private User user;
	  
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public String getRant() {
		return rant;
	}
	public void setRant(String rant) {
		this.rant = rant;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", rant=" + rant + ", deleted=" + deleted + ", user=" + user
				+ "]";
	}	
}
