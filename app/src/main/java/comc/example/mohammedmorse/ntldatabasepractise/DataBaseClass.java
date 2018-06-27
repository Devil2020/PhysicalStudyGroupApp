package comc.example.mohammedmorse.ntldatabasepractise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.concurrent.Executor;

/**
 * Created by Mohammed Morse on 22/06/2018.
 */

public class DataBaseClass extends SQLiteOpenHelper {
    static final String DataBaseName="TodoList";
    static final int Vercion=5;

    public DataBaseClass(Context context) {
        super(context, DataBaseName, null, Vercion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ContractClass.TableName+"( "+ContractClass.IdColum +" Integer primary key AUTOINCREMENT, "+ContractClass.FirstColum + " Text ,"+ContractClass.SecondColum
     +" Text );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists "+ContractClass.TableName);
        onCreate(db);
    }
    public Boolean CheckIfInDataBaseOrNot(ContractClass data){
        boolean ifIn=false;
        Cursor cursor;
        int count =-50;
        try {

           SQLiteDatabase database = getReadableDatabase();
           cursor = database.query(ContractClass.TableName,
                   new String[]{ ContractClass.IdColum ,ContractClass.FirstColum, ContractClass.SecondColum}
                   , ContractClass.FirstColum+"=?"+" and "+ContractClass.SecondColum+"=?",
                   new String[]{data.getName(),data.getPassword()},
                   null, null, null);
           cursor.moveToFirst();
            count=cursor.getCount();
            database.close();
        }catch (Exception e){
           Log.e("Error",e.getMessage());
       }
        if(count==0){
            ifIn=false;
        }
        else if(count>0){
            ifIn=true;
        }
        return ifIn;
    }
    public void InsertRow(ContractClass data){
        try {

            ContentValues values = new ContentValues();
            values.put(ContractClass.FirstColum, data.getName());
            values.put(ContractClass.SecondColum, data.getPassword());
            SQLiteDatabase database = getWritableDatabase();
            database.insert(ContractClass.TableName, null, values);
            Log.d("Morse", "Insert Done");
            database.close();
        }catch (Exception e){
            Log.e("Error","Can`t Insert");
        }

        }
    public void UpdateData(ContractClass data){
        ContentValues values=new ContentValues();
        values.put(ContractClass.FirstColum,data.getName());
        values.put(ContractClass.SecondColum,data.getPassword());
        SQLiteDatabase database=getWritableDatabase();
        database.update(ContractClass.TableName,values,ContractClass.IdColum,new String[]{String.valueOf(data.getId())});
    }
    public void DeletData(int id){
        SQLiteDatabase database=getWritableDatabase();
        database.delete(ContractClass.TableName,ContractClass.IdColum,new String[]{String.valueOf(id)});
    }



}
