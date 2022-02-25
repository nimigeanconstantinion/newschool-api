package com.example.newschool.services;

import com.example.newschool.model.Course;
import com.example.newschool.repository.CourseRepo;

public class CourseServices {
    private final CourseRepo courseRepo;

    public CourseServices(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }

    public void addCourse(Course course){
        
    }
}
