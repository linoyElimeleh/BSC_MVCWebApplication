package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class DetailsActivity extends AppCompatActivity {

    String studentId;
    Student student;
    Intent editIntent;

    //View items
    ImageView pictureImgv;
    TextView nameTv;
    TextView idTv;
    CheckBox flagCb;
    Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d("TAG", "DetailsActivity onCreate");

        //Creations and settings
        editIntent = new Intent(this, EditActivity.class);

        //Get student
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            studentId = extras.getString("studentId");
        }
        student = Model.instance.getStudent(studentId);

        getViews();
        setViews();

        //Set edit button
        editIntent.putExtra("studentId", studentId);
        //TODO: replace with fragments
        editBtn.setOnClickListener(v -> startActivityForResult(editIntent, 0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "DetailsActivity onResume");
        setViews();
    }

    //TODO: replace with fragments
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        Log.d("TAG", "DetailsActivity onActivityResult");
        super.onActivityResult(requestCode, resultCode, result);
        if (resultCode == RESULT_OK)
            if (result.hasExtra("studentId"))
                studentId = result.getExtras().getString("studentId");
        if(resultCode == RESULT_CANCELED)
            finish();
    }

    protected void getViews() {
        //Get View items
        pictureImgv = findViewById(R.id.details_picture_imgv);
        nameTv = findViewById(R.id.details_nameValue_tv);
        idTv = findViewById(R.id.details_idValue_tv);
        flagCb = findViewById(R.id.details_flag_cb);
        editBtn = findViewById(R.id.details_edit_btn);
    }

    protected void setViews() {
        //Set student values in view items
        pictureImgv.setImageResource(student.getPictureRid());
        nameTv.setText(student.getName());
        idTv.setText(student.getId());
        flagCb.setChecked(student.isFlagged());
    }

    //______________________Other Activity States_____________________________
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "DetailsActivity onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "DetailsActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "DetailsActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "DetailsActivity onDestroy");
    }

}