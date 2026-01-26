package com.gallery.backend.dtorequests.UnsplashCreation;

import java.util.List;

public class UnsplashSearchResponse {
    private int total;
    private int total_pages;
    private List<UnsplashCreation> results;

    public List<UnsplashCreation> getResults() {
        return results;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setResults(List<UnsplashCreation> results) {
        this.results = results;
    }

}
