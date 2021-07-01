package nita.krishna.glimpse_admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import nita.krishna.glimpse_admin.faculty.UpdateFaculty;
import nita.krishna.glimpse_admin.notice.DeleteNoticeActivity;
import nita.krishna.glimpse_admin.notice.UploadNotice;

public class MainActivity extends AppCompatActivity {

    CardView updateNotice, updateGallery,addEbook,updateFaculty,deleteNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        updateNotice = findViewById(R.id.updateNotice);
        updateGallery = findViewById(R.id.updateGallery);
        addEbook = findViewById(R.id.addEbook);
        updateFaculty = findViewById(R.id.updateFaculty);
        deleteNotice = findViewById(R.id.deleteNotice);


        updateNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
            }
        });
        updateGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
            }
        });
        addEbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadPdfActivity.class);
                startActivity(intent);
            }
        });

        updateFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
            }
        });
        deleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
            }
        });


    }

//    @Override
//    public void onClick(View v) {
//        switch(v.getId()){
//            case R.id.updateNotice:
//                Intent intent = new Intent(MainActivity.this, UploadNotice.class);
//                startActivity(intent);
//                break;
//        }
//    }
}