package cs.uga.edu.statecapitalsquizappv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static final String dbName = "stateQuestions.db";
    private static final String tableName = "statesTable";
    private static final String id = "id";
    private static final String colOne = "state";
    private static final String colTwo = "actualCapital";
    private static final String colThree = "cityTwo";
    private static final String colFour = "cityThree";
    private static final String colFive = "answer";

    SQLiteDatabase db;

    public DBManager(Context context) {
        super(context, dbName, null, dbVersion);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableName+" ( "+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+colOne+" TEXT, "+colTwo+" TEXT, "+colThree+" TEXT, "+colFour+" TEXT, "+colFive+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);
    }
}
