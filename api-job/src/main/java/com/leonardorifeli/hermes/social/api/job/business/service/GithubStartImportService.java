package com.leonardorifeli.hermes.social.api.job.business.service;

import org.json.JSONArray;
import org.json.JSONObject;

public class GithubStartImportService {

    private JSONObject message;

    public GithubStartImportService(JSONObject message) {
        this.message = message;
    }

    public void start() {
        this.println("");
        this.showUserInformation();
        this.showRepositoriesInformation();
    }

    private void showUserInformation() {
        JSONObject user = new JSONObject(this.message.getString("userInformation"));

        this.println("Username: "+ user.getString("login"));
        this.println("Name: "+ user.getString("name"));

        if(user.isNull("description") == false) {
            this.println("Description: "+ user.getString("description"));
        }

        this.println("Company: "+ user.getString("company"));
        this.println("Blog: "+ user.getString("blog"));
        this.println("Public_repos: "+ user.getInt("public_repos"));
        this.println("followers: "+ user.getInt("followers"));
        this.println("");

    }

    private void showRepositoriesInformation() {
        JSONArray repositories = new JSONArray(this.message.getString("repositories"));

        for(int i = 0; i < repositories.toList().size(); i++) {
            JSONObject repository = repositories.getJSONObject(i);

            this.println("## Repository ("+i+"):");
            this.println("Id: "+ repository.getInt("id"));
            this.println("Name: "+ repository.getString("name"));

            if(repository.isNull("description") == false) {
                this.println("Description: "+ repository.getString("description"));
            }

            this.println("Full Name: "+ repository.getString("full_name"));
            this.println("URL: "+ repository.getString("html_url"));

            if(repository.isNull("language") == false) {
                this.println("Language: "+ repository.getString("language"));
            }

            this.println("Default Branch: "+ repository.getString("default_branch"));
            this.println("");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

}