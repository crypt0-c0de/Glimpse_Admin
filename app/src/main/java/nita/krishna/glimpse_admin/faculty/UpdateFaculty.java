package nita.krishna.glimpse_admin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import nita.krishna.glimpse_admin.R;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView beDepartment, chDepartment, ceDepartment, cseDepartment, eeDepartment,eceDepartment,eiDepartment,meDepartment,peDepartment;
    private LinearLayout beNoData, chNoData, ceNoData, cseNoData, eeNoData,eceNoData, eiNoData,meNoData, peNoData;
    private List<TeacherData> list1, list2,list3, list4,list5, list6,list7, list8, list9;


    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        beDepartment = findViewById(R.id.beDepartment);
        chDepartment = findViewById(R.id.chDepartment);
        ceDepartment = findViewById(R.id.ceDepartment);
        cseDepartment = findViewById(R.id.cseDepartment);


        beNoData = findViewById(R.id.beNoData);
        chNoData = findViewById(R.id.chNoData);
        ceNoData = findViewById(R.id.ceNoData);
        cseNoData = findViewById(R.id.cseNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        beDepartment();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateFaculty.this, AddTeacher.class);
                startActivity(intent);
            }
        });
    }

    private void beDepartment() {
        dbRef = reference.child("Bio Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    beNoData.setVisibility(View.VISIBLE);
                    beDepartment.setVisibility(View.VISIBLE);
                }else{
                    for(DataSnapshot snapshots : snapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    beDepartment.setHasFixedSize(true);
                    beDepartment.setLayoutManager( new LinearLayoutManager(UpdateFaculty.this));

                }


            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}