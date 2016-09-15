package com.leonardorifeli.hermes.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.leonardorifeli.hermes.api.entity.GithubUser;

@Entity
@Table(name="github_repository")
public class GithubRepository {
	
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    @ManyToOne
    private GithubUser githubUser;
    
    public GithubRepository(String name) {
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
    
    public GithubUser getGithubUser() {
        return this.githubUser;
    }
 
    public void setGithubUser(GithubUser githubUser) {
        this.githubUser = githubUser;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
 
}