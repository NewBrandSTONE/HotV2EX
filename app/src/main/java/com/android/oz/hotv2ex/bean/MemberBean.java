package com.android.oz.hotv2ex.bean;

import java.io.Serializable;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public class MemberBean implements Serializable{


    private long id;
    private String username;
    private String tagline;
    private String avatar_mini;
    private String avatar_normal;
    private String avatar_large;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getAvatar_mini() {
        return avatar_mini;
    }

    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }

    public String getAvatar_normal() {
        return avatar_normal;
    }

    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    @Override
    public String toString() {
        return "MemberBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tagline='" + tagline + '\'' +
                ", avatar_mini='" + avatar_mini + '\'' +
                ", avatar_normal='" + avatar_normal + '\'' +
                ", avatar_large='" + avatar_large + '\'' +
                '}';
    }
}
