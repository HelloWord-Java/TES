package com.tes1.evaluate.domain;

public class Avgscores {
    private Integer id;

    private Integer teacherId;

    private Integer courseId;

    private Float avgscore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Float getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Float avgscore) {
        this.avgscore = avgscore;
    }
}