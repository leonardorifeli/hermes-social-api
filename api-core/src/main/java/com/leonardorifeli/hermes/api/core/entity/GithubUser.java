package com.leonardorifeli.hermes.api.core.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.leonardorifeli.hermes.api.core.entity.GithubRepository;

@Entity
@Table(name = "github_user")
public class GithubUser {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String email;

	@OneToMany(mappedBy = "github_repository", cascade = CascadeType.PERSIST)
	private List<GithubRepository> githubRepositories = new ArrayList<GithubRepository>();

	public List<GithubRepository> getGithubRepositories() {
		if (this.githubRepositories == null)
			this.githubRepositories = new ArrayList<GithubRepository>();

		return this.githubRepositories;
	}

	public void setGithubRepositories(List<GithubRepository> githubRepositories) {
		this.githubRepositories = githubRepositories;
	}

	public GithubUser(String name, String email) {
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