package com.ebookfrenzy.project05.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebookfrenzy.project05.R;

import android.widget.Button;
import androidx.navigation.Navigation;
import android.widget.ImageView;

import java.util.Objects;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Button button = requireView().findViewById(R.id.button);
        Button button2 = requireView().findViewById(R.id.button2);
        Button button3 = requireView().findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image1 = requireView().findViewById(R.id.imageView2);
                image1.setTag(R.drawable.android_image_1);
                int id1 = getDrawableId(image1);

                MainFragmentDirections.ActionMainFragmentToSecondFragment action =
                        MainFragmentDirections.actionMainFragmentToSecondFragment
                                (id1);

                Navigation.findNavController(view).navigate(action);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image2 = requireView().findViewById(R.id.imageView3);
                image2.setTag(R.drawable.android_image_2);
                int id2 = getDrawableId(image2);

                MainFragmentDirections.ActionMainFragmentToThirdFragment action2 =
                        MainFragmentDirections.actionMainFragmentToThirdFragment
                                (id2);

                Navigation.findNavController(view).navigate(action2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image3 = requireView().findViewById(R.id.imageView4);
                image3.setTag(R.drawable.android_image_3);
                int id3 = getDrawableId(image3);

                MainFragmentDirections.ActionMainFragmentToFourthFragment action3 =
                        MainFragmentDirections.actionMainFragmentToFourthFragment
                                (id3);

                Navigation.findNavController(view).navigate(action3);
            }
        });
    }

    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }
}