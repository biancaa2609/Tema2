package android.example.tema2;

import android.content.Context;
import android.os.AsyncTask;

public class UserRepository {
    private AppDatabase appDatabase;

    public UserRepository(Context context) {
        appDatabase = ApplicationController.getAppDatabase();
    }

    public void insertTask(final User user,
                           final OnUserRepositoryActionListener listener)   {
        new InsertTask(listener).execute(user);
    }

    public User getUserByName(String firstName, String lastName){
        return appDatabase.userDao().findByName(firstName, lastName);
    }

    // DO NOT PERFORM OPERATION ON MAIN THREAD AS APP WILL CRASH
    // See more details about AsyncTask in the next chapter
    private class InsertTask extends AsyncTask<User, Void, Void> {
        OnUserRepositoryActionListener listener;
        InsertTask(OnUserRepositoryActionListener listener) {
            this.listener = listener;
        }
        @Override
        protected Void doInBackground(User... users) {
            appDatabase.userDao().insertAll(users[0]);
            return null;
        }
        @Override

        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listener.actionSuccess();
        }
    }
}

// You can use an interface like this to perform actions on main thread
// when the action is done.





