package com.CPS251Projects.Project_07_RecyclerViewIntents;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter
    extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final int request_code = 5;

    Data data = new Data();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(data.getTitles().get(i));
        viewHolder.itemDetail.setText(data.getDetails().get(i));
        viewHolder.itemImage.setImageResource(data.getImages().get(i));
    }

    @Override
    public int getItemCount() {
        return data.getTitles().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), DescriptionPage.class);

                    int imageIndex = getAdapterPosition();
                    int imageResource = data.getImages().get(imageIndex);
                    i.putExtra("imageResource", imageResource);

                    String descriptTitle = itemTitle.getText().toString();
                    i.putExtra("descriptTitle", descriptTitle);

                    String descriptDetail = itemDetail.getText().toString();
                    i.putExtra("descriptDetail", descriptDetail);

                    v.getContext().startActivity(i);
                }
            });
        }
    }

}
