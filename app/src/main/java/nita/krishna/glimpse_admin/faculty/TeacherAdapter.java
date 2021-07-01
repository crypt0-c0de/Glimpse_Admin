package nita.krishna.glimpse_admin.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import nita.krishna.glimpse_admin.R;

import static android.os.Build.VERSION_CODES.R;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {
    private List<TeacherData> list;
    private Context context;

    public TeacherAdapter(List<TeacherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(nita.krishna.glimpse_admin.R.layout.faculty_item_layout,parent,false);
        return new TeacherViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TeacherAdapter.TeacherViewAdapter holder, int position) {

        TeacherData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        Picasso.get().load(item.getImage()).into(holder.imageView);
;
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Update Teacher", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private Button update;
        private ImageView imageView;

        public TeacherViewAdapter(@NonNull @NotNull View itemView) {
            super(itemView);

            name = itemView.findViewById(nita.krishna.glimpse_admin.R.id.teacherName);
            email = itemView.findViewById(nita.krishna.glimpse_admin.R.id.teacherEmail);
            post = itemView.findViewById(nita.krishna.glimpse_admin.R.id.teacherPost);
            update = itemView.findViewById(nita.krishna.glimpse_admin.R.id.teahcerUpdate);
            imageView = itemView.findViewById(nita.krishna.glimpse_admin.R.id.addTeacherImage);
        }
    }
}
