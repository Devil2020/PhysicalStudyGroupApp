package comc.example.mohammedmorse.ntldatabasepractise;

import android.provider.BaseColumns;

/**
 * Created by Mohammed Morse on 22/06/2018.
 */

public class ContractClass implements BaseColumns {
    static final String TableName="Users";
    static final String IdColum="Id";
    static final String FirstColum="Name";
    static final String SecondColum="Password";

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id;
    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String Name;
    public String Password;
}
