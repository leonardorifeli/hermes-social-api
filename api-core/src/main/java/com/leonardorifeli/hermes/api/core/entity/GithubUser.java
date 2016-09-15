package com.leonardorifeli.hermes.api.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.leonardorifeli.hermes.api.core.entity.Repository;

@Entity
@Table(name="github_user")
public class GithubUser {
	
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    private String email;
    
    @OneToMany(mappedBy="repository",cascade=CascadeType.PERSIST)
    private List<Repository> repositories = new ArrayList<Repository>(); 
    
    public List<Repository> getRepositories() {
        return this.repositories;
    }
    
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
     
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
 
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
 
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
 
}