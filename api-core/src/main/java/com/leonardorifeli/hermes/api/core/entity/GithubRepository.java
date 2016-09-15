package com.leonardorifeli.hermes.api.core.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.leonardorifeli.hermes.api.core.entity.User;

@Entity
@Table(name="github_repository")
public class GithubRepository {
	
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    @ManyToOne
    private User user;
    
    public Repository(String name) {
        this.name = name;
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
    
    public User getUser() {
        return this.user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
 
}