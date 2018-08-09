package com.yrocha.bookshelfbackend.entity;

import com.yrocha.bookshelfbackend.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(name = "avatar_img")
    private String avatarImg;

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }
}
