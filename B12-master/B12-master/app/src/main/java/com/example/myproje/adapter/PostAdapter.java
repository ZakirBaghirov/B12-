package com.example.myproje.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproje.R;
import com.example.myproje.databinding.RecyclerRowBinding;
import com.example.myproje.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList=postArrayList;
    }

    class PostHolder extends RecyclerView.ViewHolder{
        RecyclerRowBinding recyclerRowBinding;
        public PostHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding=recyclerRowBinding;
        }
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post currentPost = postArrayList.get(position);

        String name = (currentPost.name != null) ? currentPost.name : "İsimsiz";
        String comment = (currentPost.comment != null) ? currentPost.comment : "";
        String imageUrl = (currentPost.downloadUrl != null) ? currentPost.downloadUrl : "";

        holder.recyclerRowBinding.textViewFamily.setText(name);
        holder.recyclerRowBinding.textViewComment.setText(comment);

        if (!imageUrl.isEmpty()) {
            Picasso.get().load(imageUrl).into(holder.recyclerRowBinding.imageViewFamily);
        } else {
            holder.recyclerRowBinding.imageViewFamily.setImageResource(R.drawable.user);
        }
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }
}
