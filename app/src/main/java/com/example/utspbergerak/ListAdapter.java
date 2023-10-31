package com.example.utspbergerak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<List> Listaja; // Mengganti <Hero> dengan <List>

    public ListAdapter(ArrayList<List> list) { // Mengganti <Hero> dengan <List>
        this.Listaja = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_nama, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        List list = Listaja.get(position);
        holder.imgPhoto.setImageResource(list.getPhoto());
        holder.tvName.setText(list.getName());
        holder.tvDescription.setText(list.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan data pengguna yang ditekan
                List user = Listaja.get(holder.getAdapterPosition());


                // Membuat Intent untuk memulai DetailUserActivity
                Intent Intent = new Intent(view.getContext(), DescUser.class);
                Intent tail = new Intent(view.getContext(), DescUser.class);
                Intent.putExtra("position", position);

                // Mengirim data pengguna ke DetailUserActivity
                Intent.putExtra("name", user.getName()); //
                Intent.putExtra("description", user.getDescription());
                Intent.putExtra("photo", user.getPhoto());

                view.getContext().startActivity(Intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return Listaja.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}

