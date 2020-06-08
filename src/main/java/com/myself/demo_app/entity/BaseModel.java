package com.myself.demo_app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public abstract class BaseModel {

    @Column(updatable = false)
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    private Boolean isActive;

    @PrePersist
    public void setInsertData(){
        this.createdAt = new Date();
        this.isActive = true;
    }

 //   @PostPersist
 //   public void setUpdateData(){
 //       this.updatedAt = new Date();
 //   }
}
