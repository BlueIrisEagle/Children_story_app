package com.example.android.comeback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.SQLOutput;

import static java.security.AccessController.getContext;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContents;


    Adapter(Context context, String[] titles, String[] contents){
        this.inflater = LayoutInflater.from(context);
        this.sTitles = titles;
        this.sContents = contents;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = sTitles[position];
        String content = sContents[position];

        holder.storyTitle.setText(title);
        holder.storyContent.setText(content);

    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView storyTitle,storyContent;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        // Implementing OnClickListener

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(),Details.class);
                in.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
                in.putExtra("ContentOfStory",sContents[getAdapterPosition()]);

                //Log.d("MyActivity","Before getContext");

                view.getContext().startActivity(in);

                //deligate


                System.out.println(view.getContext().toString());

//                Log.d("MyActivity",view.getContext().toString());
            }
        });

        storyTitle = itemView.findViewById(R.id.storyTitle);
        storyContent = itemView.findViewById(R.id.storyDescription);
    }
}
}