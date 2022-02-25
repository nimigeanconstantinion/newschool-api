package com.example.newschool;

import com.example.newschool.model.Book;
import com.example.newschool.model.Course;
import com.example.newschool.model.Student;
import com.example.newschool.repository.CourseRepo;
import com.example.newschool.repository.StudentRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class NewSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewSchoolApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo, CourseRepo courseRepo) {
        return args -> {
            Faker fk = new Faker();
//            for(int i=1;i<10;i++){
//                Student s=new Student();
//                s.setFirstName(fk.name().firstName());
//                s.setLastName(fk.name().lastName());
//                s.setEmail(fk.internet().emailAddress());
//                s.setAge(fk.number().numberBetween(18,70));
//                s.setPassword("123");
//                System.out.println(s);
//                studentRepo.save(s);
//            }
//////
//                for(int i=1;i<10;i++){
//                    Course c=new Course();
//                    c.setName(fk.team().sport());
//                    c.setDepartment(fk.demographic().educationalAttainment());
//                    c.setDescription(fk.team().sport());
//                    courseRepo.save(c);
//                }
//                Course c=courseRepo.findById(1L).get();
                Student s=studentRepo.findById(1L).get();
//
//            System.out.println(c);
           System.out.println(s);
//            s.addCourse(c);
//            studentRepo.save(s);
            Book book=new Book("sdlksldkldjfl",LocalDate.now());


            System.out.println(s.getBooks());
          //  studentRepo.save(s);

        };
    }
}
