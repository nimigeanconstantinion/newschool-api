package com.example.newschool.services;

import com.example.newschool.exceptions.BadRequest;
import com.example.newschool.model.Student;
import com.example.newschool.repository.CourseRepo;
import com.example.newschool.repository.StudentRepo;
import org.springframework.stereotype.Service;


@Service
public class StudentServices {
    private final StudentRepo studentRepo;
    //private final BookRepo bookRepo;
    private final CourseRepo courseRepo;

    public StudentServices(StudentRepo studentRepo,CourseRepo courseRepo){
        this.studentRepo=studentRepo;
        //this.bookRepo=bookRepo;
        this.courseRepo=courseRepo;
    }

    public void addStudent(Student s){
        if(!studentRepo.findStudentByEmail(s.getEmail()).isPresent()){
            studentRepo.save(s);
        }else{
                throw new BadRequest("This Email address does not exists!");
        }
    }

    public void removeStudent(Student s){
        if(studentRepo.findById(s.getId()).isPresent()){
            studentRepo.findAll().remove(s);
        }else{
            throw new BadRequest("Student does not exit!");
        }
    }

//    public void updateStudent(Student uS){
//        if(studentRepo.findById(uS.getId()).isPresent()){
//            Student eS=studentRepo.findById(uS.getId()).get();
//            eS.setFirst_name(uS.getFirst_name());
//            eS.setLast_name(uS.getLast_name());
//            eS.setAge(uS.getAge());
//
//        }else{
//            throw new BadRequest("Student does not exit!");
//        }
//
//    }

//    //public void addBook(Long idStudent, Book book){
//        if(studentRepo.findById(idStudent).isPresent()) {
//            Student student = studentRepo.findById(idStudent).get();
//            if(!bookRepo.findBooksByBook_nameaAndStudent(book.getBook_name(),idStudent).isPresent()){
//                book.setStudent(student);
//                bookRepo.save(book);
//                student.addBook(book);
//                studentRepo.save(student);
//            }else{
//                throw new BadRequest("You don't own this book!");
//            }
//
//        }else{
//            throw new BadRequest("Student does not exist!");
//        }
//    }
//
//    public void removeBook(Long idS,Long idB){
//        if(studentRepo.findById(idS).isPresent()) {
//            Student student = studentRepo.findById(idS).get();
//            if(bookRepo.findById(idB).isPresent()){
//                Book book=bookRepo.findById(idB).get();
//                student.delBook(book);
//                studentRepo.save(student);
//                bookRepo.deleteById(idB);
//            }
//        }
//    }
//

}
