package com.hibernate.one2one.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;
    public InstructorDetail() {
    }
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getyoutubeChannel() {
        return youtubeChannel;
    }
    public void setyoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    @Override
    public String toString() {
        return "InstructorDetails [youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + ", id=" + id + "]";
    }
}
