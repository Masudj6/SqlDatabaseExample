package example.com.finaldatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Admin on 3/24/17.
 */

public class MyDatabase extends SQLiteOpenHelper {


    public static MyDatabase instants = null;
    private static final String KEY_DABASE_NAME = "DABASE_NAME";
    private static final int KEY_VERSION = 1;


    // table schema
    public static final String KEY_TABLE_NAME = "MY_TABLE";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static  final  String KEY_MOBILE = "moible";


    // create table sql

    public  static String create_table = "CREATE TABLE " +KEY_TABLE_NAME +"("+KEY_ID+" INTEGER ,"+KEY_NAME+" TEXT, "+KEY_MOBILE+" TEXT);";

    private   MyDatabase(Context context) {
        super(context, KEY_DABASE_NAME, null, KEY_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     *
     * @param context
     * @return
     */
    public static MyDatabase getInstans(Context context){

        if (instants == null){
            instants = new MyDatabase(context);
        }
        return  instants;
    }


    public void test(){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.close();


    }


    public long insertData(Person person){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_MOBILE, person.getMobile());

        long insert = db.insert(KEY_TABLE_NAME, null, values);

        return insert;


    }


    public ArrayList<Person> getAllTableData(){

        ArrayList<Person> allData = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + KEY_TABLE_NAME + "", null);

        if (cursor .moveToFirst()== true) {
            while(cursor.moveToNext()){

                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                String mobile = cursor.getString(cursor.getColumnIndex(KEY_MOBILE));


                Person p = new Person(id, name, mobile);
                allData.add(p);

            }
        }

        return  allData;
    }


}
