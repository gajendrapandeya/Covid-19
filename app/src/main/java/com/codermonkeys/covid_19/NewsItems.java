package com.codermonkeys.covid_19;

public class NewsItems {

    private String imageUrl;
    private String newsTitle;
    private String description;

    public NewsItems(String imageUrl, String newsTitle, String description) {
        this.imageUrl = imageUrl;
        this.newsTitle = newsTitle;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getDescription() {
        return description;
    }
}
