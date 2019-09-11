package com.research.model.Vo;

public class Report {
    private Integer id;

    private String name;

    private String unit;

    private String type;

    private String author;

    private String timeFormular;

    private String disciplineF;

    private String project;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTimeFormular() {
        return timeFormular;
    }

    public void setTimeFormular(String timeFormular) {
        this.timeFormular = timeFormular == null ? null : timeFormular.trim();
    }

    public String getDisciplineF() {
        return disciplineF;
    }

    public void setDisciplineF(String disciplineF) {
        this.disciplineF = disciplineF == null ? null : disciplineF.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}