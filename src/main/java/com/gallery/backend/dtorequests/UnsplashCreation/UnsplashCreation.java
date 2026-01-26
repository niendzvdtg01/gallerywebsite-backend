package com.gallery.backend.dtorequests.UnsplashCreation;

public class UnsplashCreation {
    private String id;
    private Urls urls;
    private String source;
    private User user;
    private String description;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Urls getUrls() {
        return this.urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public class Urls {
        private String small;

        public void setSmall(String small) {
            this.small = small;
        }

        public String getSmall() {
            return this.small;
        }
    }

    public class User {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
