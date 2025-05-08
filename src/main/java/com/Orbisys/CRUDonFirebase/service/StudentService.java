package com.Orbisys.CRUDonFirebase.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.Orbisys.CRUDonFirebase.model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Service
public class StudentService {

    private Student student;

    public boolean saveStudent(Student student) {
        try {

            DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference("Student");

            dbReference.child(String.valueOf(student.getStudentId())).setValueAsync(student);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error while saving student into firebase DB");
            return false;
        }
    }

    public Student getStudent(int id) {

        CompletableFuture<Student> completableFuture = new CompletableFuture<>();

        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference("Student")
                .child(String.valueOf(id));

        dbReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                student = snapshot.getValue(Student.class);
                completableFuture.complete(student);
                System.out.println("getStudent: " + student);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("onCancelled: " + error);
            }

        });

        try {
            return completableFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Student updateStudent(int id, Student newStudent) {

        CompletableFuture<Student> completableFuture = new CompletableFuture<>();

        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference("Student")
                .child(String.valueOf(id));

        // fetch student form firebase;
        dbReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                student = snapshot.getValue(Student.class);

                // set new values in old student;
                student.setName(newStudent.getName());
                student.setAvailable(newStudent.isAvailable());

                completableFuture.complete(student);

                System.out.println("updatedStudent: " + student);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println(error);
            }

        });

        try {

            student = completableFuture.get();

            // save updated student into firebase;
            dbReference.setValueAsync(student);

            return student;
        } catch (Exception e) {

            return null;
        }

    }

    public boolean deleteStudent(int id) {
        try {

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Student")
                    .child(String.valueOf(id));

            databaseReference.removeValueAsync();

        } catch (Exception e) {
            return false;
        }

        System.out.println("Delete Success" + id);
        return true;
    }
}
