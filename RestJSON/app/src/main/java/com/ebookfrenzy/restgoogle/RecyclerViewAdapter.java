package com.ebookfrenzy.restgoogle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Names> namesList;


    //CREATE CONSTRUCTOR AND ADD LIST
    public RecyclerViewAdapter(ArrayList<Names> nLst) {
       namesList = nLst;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name, parent, false);

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        //WE GET THE POSITION OF THE COUPON LIST AND THEN CAN GET THE VALUE OF ALL THE COUPONS FROM
        //THE ARRAYLIST
        Names names = namesList.get(position);
        viewHolder.name.setText(names.getName());
        viewHolder.address.setText(names.getAddress());
        viewHolder.email.setText(names.getEmail());
        viewHolder.phone.setText(names.getPhone());
        viewHolder.card_number.setText(String.valueOf(position + 1));
        viewHolder.age.setText(String.valueOf(names.getAge()));
        viewHolder.eye_color.setText(names.getEyeColor());
        viewHolder.company.setText(names.getGender());
        if (names.getGender().equals("male")) {
            viewHolder.profile_pic.setImageResource(R.drawable.male);
        } else if(names.getGender().equals("female")){
            viewHolder.profile_pic.setImageResource(R.drawable.female);
        }

    }

    @Override
    public int getItemCount() {
        //WE ARE USING AN ARRAY LIST SO WE USE THE SIZE METHOD NOT LENGTH FROM THE ARRAY
        return namesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView address;
        public TextView email;
        public TextView phone;
        public TextView card_number;
        public TextView age;
        public TextView eye_color;
        public TextView company;
        public ImageView profile_pic;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            address = view.findViewById(R.id.address);
            email = view.findViewById(R.id.email);
            phone = view.findViewById(R.id.phone);
            card_number = view.findViewById(R.id.card_number);
            age = view.findViewById(R.id.age);
            eye_color = view.findViewById(R.id.eye_color);
            company = view.findViewById(R.id.company);
            profile_pic = view.findViewById(R.id.profile_pic);
        }

    }

}
