package com.ebookfrenzy.roomdemo.ui.main;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ebookfrenzy.roomdemo.Contact;
import com.ebookfrenzy.roomdemo.ContactRepository;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ContactRepository contact_repository;
    private LiveData<List<Contact>> allContacts;
    private MutableLiveData<List<Contact>> search;

    public MainViewModel (Application application) {
        super(application);
        contact_repository = new ContactRepository(application);
        allContacts = contact_repository.getAllContacts();
        search = contact_repository.getSearchResults();
    }

    MutableLiveData<List<Contact>> getSearch() {return search; }
    LiveData<List<Contact>> getAllContacts() {
        return allContacts;
    }
    public void insertContact(Contact contact) {
        contact_repository.insertContact(contact);
    }
    public void findContact(String name) {
        contact_repository.findContact(name);
    }
    public void deleteContact(String name) { contact_repository.deleteContact(name); }
    public void sortAscContact() { contact_repository.sortAscContact(); }
    public void sortDescContact() { contact_repository.sortDescContact();}
}