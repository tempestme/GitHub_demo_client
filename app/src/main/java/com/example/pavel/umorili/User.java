package com.example.pavel.umorili;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pavel on 17.12.17.
 */

public class User {


    String login;
    String id;
    String avatar_url;
    String company;
    String location;

    public User(String login, String id, String avatar_url, String company, String location) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.company = company;
        this.location = location;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }


    //            "login": "tempestme",
//            "id": 9161675,
//            "avatar_url": "https://avatars2.githubusercontent.com/u/9161675?v=4",
//            "gravatar_id": "",
//            "url": "https://api.github.com/users/tempestme",
//            "html_url": "https://github.com/tempestme",
//            "followers_url": "https://api.github.com/users/tempestme/followers",
//            "following_url": "https://api.github.com/users/tempestme/following{/other_user}",
//            "gists_url": "https://api.github.com/users/tempestme/gists{/gist_id}",
//            "starred_url": "https://api.github.com/users/tempestme/starred{/owner}{/repo}",
//            "subscriptions_url": "https://api.github.com/users/tempestme/subscriptions",
//            "organizations_url": "https://api.github.com/users/tempestme/orgs",
//            "repos_url": "https://api.github.com/users/tempestme/repos",
//            "events_url": "https://api.github.com/users/tempestme/events{/privacy}",
//            "received_events_url": "https://api.github.com/users/tempestme/received_events",
//            "type": "User",
//            "site_admin": false,
//            "name": "Pavel Yakunin",
//            "company": "LM group",
//            "blog": "",
//            "location": "Moscow",
//            "email": null,
//            "hireable": true,
//            "bio": null,
//            "public_repos": 5,
//            "public_gists": 0,
//            "followers": 2,
//            "following": 0,
//            "created_at": "2014-10-12T07:33:44Z",
//            "updated_at": "2017-12-11T07:20:36Z"


}
