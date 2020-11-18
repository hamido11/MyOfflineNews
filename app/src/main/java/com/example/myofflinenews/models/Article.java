package com.example.myofflinenews.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
@Entity( tableName = "article_info")
public class Article {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @SerializedName("author")
    @ColumnInfo(name = "author")
    private String author;
    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;
    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    private String publishedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }
}



