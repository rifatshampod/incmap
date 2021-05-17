package pwdmap.map.incmap;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {

    private List<CategoryModel>categoryModelList;


    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(categoryModelList.get(position).getUrl(),categoryModelList.get(position).getName(),categoryModelList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private CircleImageView imageView;
        private TextView title;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
        }

        private void setData(String url, final String title, final String description){
            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.title.setText(title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Intent setIntent = new Intent(itemView.getContext(),Article.class);
                    setIntent.putExtra("title",title);
                    setIntent.putExtra("description",description);
                    itemView.getContext().startActivity(setIntent);

                }
            });
        }
    }
}
