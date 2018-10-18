package com.webapp.rantsroom.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class User extends AuditModel{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;	
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String passwordConfirm;
    private String email;
    private boolean active;
    private boolean email_confirmed;
    private String confirmationToken;
    
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Post> posts;
    
    @ManyToMany
    @JoinTable(name = "user_role", 
    joinColumns = @JoinColumn(name = "User_ID"), 
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;    
        
    
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    } 

	public boolean isEmail_confirmed() {
		return email_confirmed;
	}

	public void setEmail_confirmed(boolean email_confirmed) {
		this.email_confirmed = email_confirmed;
	}

    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
}
