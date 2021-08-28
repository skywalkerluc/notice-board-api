package tech.cers.noticeboard.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notice implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;
  private String title;
  private String description;

  @Column(nullable = false, updatable = false)
  private Date publishDate;
  private Date viewDate;

  public Notice() { }

  public Notice(String title, String description, Date publishDate, Date viewDate) {
    this.title = title;
    this.description = description;
    this.publishDate = publishDate;
    this.viewDate = viewDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public Date getViewDate() {
    return viewDate;
  }

  public void setViewDate(Date viewDate) {
    this.viewDate = viewDate;
  }

  @Override
  public String toString(){
    return "Notice{" +
      "id=" + id +
      "title=" + title +
      "description=" + description +
      "publishDate=" + publishDate +
      "viewDate=" + viewDate +
      "}";
  }
}
