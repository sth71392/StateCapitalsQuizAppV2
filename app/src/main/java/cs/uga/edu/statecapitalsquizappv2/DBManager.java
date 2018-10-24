package cs.uga.edu.statecapitalsquizappv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    private static final int dbVersion = 2;
    private static final String dbName = "stateQuestions.db";
    private static final String tableName = "statesTable";
    private static final String scoresTableName = "scoresTable";
    private static final String id = "id";
    private static final String colOne = "state";
    private static final String colTwo = "actualCapital";
    private static final String colThree = "cityTwo";
    private static final String colFour = "cityThree";
    private static final String colFive = "answer";
    private static final String scoresCol = "scores";
    private static final String dateCol = "dates";

    SQLiteDatabase db;

    public DBManager(Context context) {
        super(context, dbName, null, dbVersion);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableName+" ( "+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+colOne+" TEXT, "+colTwo+" TEXT, "+colThree+" TEXT, "+colFour+" TEXT, "+colFive+" TEXT)");
        db.execSQL("CREATE TABLE "+scoresTableName+" ( "+id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+scoresCol+" TEXT, "+dateCol+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        db.execSQL("DROP TABLE IF EXISTS "+scoresTableName);
        onCreate(db);
    }

    public void insert(String state, String actualCapital, String cityTwo, String cityThree, String answer){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(colOne, state);
        values.put(colTwo, actualCapital);
        values.put(colThree, cityTwo);
        values.put(colFour, cityThree);
        values.put(colFive, answer);
        db.insert(tableName, null, values);
    }

    public void insertScoresAndDates(String score, String date){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(scoresCol, score);
        values.put(dateCol, date);
        db.insert(scoresTableName, null, values);
    }

    public void deleteFromDB(){
        db.execSQL("DELETE FROM " + tableName + " WHERE " + colOne + "= '" + "California" + "'");
    }

    public List<stateQuestion> getAllStates(){
        List<stateQuestion> stateArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                stateQuestion question = new stateQuestion();

                String stateText = cursor.getString(cursor.getColumnIndex(colOne));
                question.setQuestion(stateText);

                String choiceOneText = cursor.getString(cursor.getColumnIndex(colTwo));
                question.setCapitalChoice(0, choiceOneText);

                String choiceTwoText = cursor.getString(cursor.getColumnIndex(colThree));
                question.setCapitalChoice(1, choiceTwoText);

                String choiceThreeText = cursor.getString(cursor.getColumnIndex(colFour));
                question.setCapitalChoice(2, choiceThreeText);

                String answerText = cursor.getString(cursor.getColumnIndex(colFive));
                question.setAnswer(answerText);

                stateArrayList.add(question);
            } while(cursor.moveToNext());
            Collections.shuffle(stateArrayList);
        }
        return stateArrayList;
    }



}
