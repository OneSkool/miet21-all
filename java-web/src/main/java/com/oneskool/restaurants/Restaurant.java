package com.oneskool.restaurants;

import java.util.Arrays;

public class Restaurant {

    static enum REST_TYPE {
        INDIAN,
        CHINESE
    };

    private String id;
    private REST_TYPE restType;
    private String name;
    private String description;
    private String addressJson;
    private String url;
    private String[] tags;
    private int likes;

    public Restaurant() {
        // default
    }

    public Restaurant(String id, REST_TYPE restType, String name, String description) {
        this.id = id;
        this.restType = restType;
        this.name = name;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddressJson() {
        return addressJson;
    }

    public String getUrl() {
        return url;
    }

    public String[] getTags() {
        return tags;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addressJson='" + addressJson + '\'' +
                ", url='" + url + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", likes=" + likes +
                '}';
    }
}
