package com.ebookfrenzy.roomdemo;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import android.app.Application;
import androidx.lifecycle.LiveData;

public class ContactRepository {

    private MutableLiveData<List<Contact>> searchResults =
            new MutableLiveData<>();
    private LiveData<List<Contact>> allContacts;
    private ContactDao contactDao;

    public LiveData<List<Contact>> getAllContacts() {
        return allContacts;
    }

    public MutableLiveData<List<Contact>> getSearchResults() {
        return searchResults;
    }

    public ContactRepository(Application application) {
        ContactRoomDatabase db;
        db = ContactRoomDatabase.getDatabase(application);
        contactDao = db.contactDao();
        allContacts = contactDao.getAllContacts();
    }

    public void insertContact(Contact new_contact) {
        InsertAsyncTask task = new InsertAsyncTask(contactDao);
        task.execute(new_contact);
    }

    public void deleteContact(String name) {
        DeleteAsyncTask task = new DeleteAsyncTask(contactDao);
        task.execute(name);
    }

    public void findContact(String name) {
        QueryAsyncTask task = new QueryAsyncTask(contactDao);
        task.delegate = this;
        task.execute(name);
    }

    public void sortAscContact() {
        AscSortAsyncTask task = new AscSortAsyncTask(contactDao);
        task.delegate = this;
        task.execute();
    }

    public void sortDescContact() {
        DescSortAsyncTask task = new DescSortAsyncTask(contactDao);
        task.delegate = this;
        task.execute();
    }

    private void asyncFinished(List<Contact> results) {
        searchResults.setValue(results);
    }

    private static class QueryAsyncTask extends
            AsyncTask<String, Void, List<Contact>> {

        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        QueryAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.findContact(params[0]);
        }

        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }

    private static class AscSortAsyncTask extends
            AsyncTask<String, Void, List<Contact>> {

        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        AscSortAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.sortAscContact();
        }

        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }

    private static class DescSortAsyncTask extends
            AsyncTask<String, Void, List<Contact>> {

        private ContactDao asyncTaskDao;
        private ContactRepository delegate = null;

        DescSortAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Contact> doInBackground(final String... params) {
            return asyncTaskDao.sortDescContact();
        }

        @Override
        protected void onPostExecute(List<Contact> result) {
            delegate.asyncFinished(result);
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Contact, Void, Void> {

        private ContactDao asyncTaskDao;

        InsertAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            asyncTaskDao.insertContact(params[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<String, Void, Void> {

        private ContactDao asyncTaskDao;

        DeleteAsyncTask(ContactDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            asyncTaskDao.deleteContact(params[0]);
            return null;
        }
    }
}

