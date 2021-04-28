package com.ebookfrenzy.roomdemo.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebookfrenzy.roomdemo.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ebookfrenzy.roomdemo.Contact;


import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    private int contactItemLayout;
    private List<Contact> contactList;
    private OnTrashListener onTrashListener;

    public ContactListAdapter(int layoutId, OnTrashListener onTrashListener) {
        contactItemLayout = layoutId;
        this.onTrashListener = onTrashListener;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contacts) {
        contactList = contacts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(
                parent.getContext()).inflate(contactItemLayout, parent, false);
        return new ViewHolder(view, onTrashListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView name = holder.name;
        name.setText(contactList.get(listPosition).getName());

        TextView number = holder.number;
        number.setText(String.valueOf(contactList.get(listPosition).getNumber()));

        holder.item_image.setImageResource(R.drawable.garbage_can);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView number;
        ImageView item_image;
        OnTrashListener onTrashListener;
        ViewHolder(View itemView, OnTrashListener onTrashListener) {
            super(itemView);
            name = itemView.findViewById(R.id.contact_name_row);
            number = itemView.findViewById(R.id.contact_number_row);
            item_image = itemView.findViewById(R.id.item_image);
            this.onTrashListener = onTrashListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTrashListener.onTrashClick(getAdapterPosition());
        }
    }

    public interface OnTrashListener {
        void onTrashClick(int position);
    }
}
