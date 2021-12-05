package com.example.studentsapp.model;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.studentsapp.R;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Model {
    public static final Model instance = new Model();
    List<Student> data = new LinkedList<Student>();

    //Data Initializer
    private Model() {
        for (int i = 0; i < 11; i++) {
            Student s = new Student("" + i,"Student ",false);
            data.add(s);
        }
        data.get(0).setPictureRid(R.drawable.avatar0);
        data.get(1).setPictureRid(R.drawable.avatar1);
        data.get(2).setPictureRid(R.drawable.avatar2);
        data.get(3).setPictureRid(R.drawable.avatar3);
        data.get(4).setPictureRid(R.drawable.avatar4);
        data.get(5).setPictureRid(R.drawable.avatar5);
        data.get(6).setPictureRid(R.drawable.avatar6);
        data.get(7).setPictureRid(R.drawable.avatar7);
        data.get(8).setPictureRid(R.drawable.avatar8);
        data.get(9).setPictureRid(R.drawable.avatar9);
        data.get(10).setPictureRid(R.drawable.avatar10);
    }

    public List<Student> getAllStudents() {
        return data;
    }

    public Student getStudent(String id) {
        if (!exists(id))
            return null;
        return data.stream().filter(s -> s.getId().equals(id)).findAny().get();
    }

    public void addStudent(Student student) {
        data.add(student);
    }

    public void removeStudent(Student student) {
        data.remove(student);
    }

    public boolean exists(String id) {
        return data.stream().anyMatch(s -> s.getId().equals(id));
    }

    public void updateStudent(Student student, String id, String name, boolean flag, int pictureRid) {
        student.setId(id);
        student.setName(name);
        student.setFlag(flag);
        student.setPictureRid(pictureRid);
    }
}