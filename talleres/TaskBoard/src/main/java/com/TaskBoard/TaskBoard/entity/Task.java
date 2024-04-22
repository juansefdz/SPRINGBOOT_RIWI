package com.TaskBoard.TaskBoard.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 255, nullable = false)
    private String task_description;
    @Column(nullable = false)
    private LocalDate creation_date;
    @Column(nullable = false)
    private LocalTime creation_time;
    @Column(length = 50,nullable = false)
    private String task_state;

    /*CONSTRUCTOR*/

    public Task() {
    }

    public Task(Long id, String task_title, String task_description, LocalDate creation_date, LocalTime creation_time, String task_state) {
        this.id = id;
        this.title = task_title;
        this.task_description = task_description;
        this.creation_date = creation_date;
        this.creation_time = creation_time;
        this.task_state = task_state;
    }

    /*GET&SET*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask_title() {
        return title;
    }

    public void setTask_title(String title) {
        this.title = title;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public LocalTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalTime creation_time) {
        this.creation_time = creation_time;
    }

    public String getTask_state() {
        return task_state;
    }

    public void setTask_state(String task_state) {
        this.task_state = task_state;
    }

    /*ToString*/

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_title='" + title + '\'' +
                ", task_description='" + task_description + '\'' +
                ", creation_date=" + creation_date +
                ", creation_time=" + creation_time +
                ", task_state='" + task_state + '\'' +
                '}';
    }
}
