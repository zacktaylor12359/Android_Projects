package com.ebookfrenzy.roomdemo.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ebookfrenzy.roomdemo.Contact;
import com.ebookfrenzy.roomdemo.R;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;


public class MainFragment extends Fragment implements ContactListAdapter.OnTrashListener {

    private MainViewModel mViewModel;
    private ContactListAdapter adapter;
    private EditText contactName;
    private EditText contactNumber;


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
        setHasOptionsMenu(true);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        contactName = getView().findViewById(R.id.contactName);
        contactNumber = getView().findViewById(R.id.contactPhone);
        observerSetup();
        recyclerSetup();
    }

    private void observerSetup() {
        mViewModel.getAllContacts().observe(getViewLifecycleOwner(),
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {
                        adapter.setContactList(contacts);
                    }
                });

        mViewModel.getSearch().observe(getViewLifecycleOwner(),
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {

                        if (contacts.size() > 0) {
                            adapter.setContactList(contacts);
                        } else {
                            Toast.makeText(getActivity(), "No match", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void recyclerSetup() {

        RecyclerView recyclerView;

        adapter = new ContactListAdapter(R.layout.product_list_item, this);
        recyclerView = getView().findViewById(R.id.product_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void clearFields() {
        contactName.setText("");
        contactNumber.setText("");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.option_show:
                showContacts();
                return true;
            case R.id.option_add:
                addContact();
                return true;
            case R.id.option_find:
                findContact();
                return true;
            case R.id.option_sort_asc:
                showAscContact();
                return true;
            case R.id.option_sort_desc:
                showDescContact();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showContacts() {
        mViewModel.getAllContacts().observe(getViewLifecycleOwner(),
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(@Nullable final List<Contact> contacts) {
                        adapter.setContactList(contacts);
                    }
                });
    }

    private void addContact() {
        String name = contactName.getText().toString();
        String number = contactNumber.getText().toString();
        String temp_number = "";

        if (!name.equals("") && !number.equals("")) {
            for (int i = 0; i < number.length(); i++){
                if(Character.isDigit(number.charAt(i))) {
                    temp_number = temp_number.concat(String.valueOf(number.charAt(i)));
                }
            }

            if(temp_number.length() <= 10 && temp_number.length() > 7){
                number = ("(" + temp_number.substring(0, 3) + ") " + temp_number.substring(3, 6) + "-"
                + temp_number.substring(6));
            }   else if(temp_number.length() <= 7 && temp_number.length() > 3){
                number = (temp_number.substring(0, 3) + "-" + temp_number.substring(3));
            }
            Contact contact = new Contact(name, number);
            mViewModel.insertContact(contact);
            clearFields();
        } else {
            Toast.makeText(getActivity(), "insufficient info", Toast.LENGTH_LONG).show();
        }
    }

    private void findContact() {
        mViewModel.findContact('%' + contactName.getText().toString() + '%');
    }

    private void showAscContact() {
        mViewModel.sortAscContact();
    }

    private void showDescContact() {
        mViewModel.sortDescContact();
    }

    @Override
    public void onTrashClick(int position) {
        Log.i("thing", String.valueOf(position));

        mViewModel.deleteContact(adapter.getContactList().get(position).getName());
        clearFields();
    }
}