/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobj;

/**
 *
 * @author Admin
 */
public class News {
    private int id;
    private String title;
    private String content;
    private String description;
    private String createddate;
    private String images;

    public News() {
        
    }

    public News(int id, String title, String content, String description, String createddate, String images) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
        this.createddate = createddate;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", content=" + content + ", description=" + description + ", createddate=" + createddate + ", images=" + images + '}';
    }
    
    
}
