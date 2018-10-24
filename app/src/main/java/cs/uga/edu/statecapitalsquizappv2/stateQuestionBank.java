package cs.uga.edu.statecapitalsquizappv2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class stateQuestionBank {

    List<stateQuestion> questionList = new ArrayList<>();
    DBManager myDB;

    public int getLength(){
        return questionList.size();
    }

    public String getStateQuestion(int i){
        return questionList.get(i).getQuestion();
    }

    public String getCapitalChoice(int i, int num){
        return questionList.get(i).getCapitalChoice(num - 1);
    }

    public String getRightAnswer(int i){
        return questionList.get(i).getAnswer();
    }

    public void initialQuestions(Context context){
        myDB = new DBManager(context);
        questionList = myDB.getAllStates();
    }

}
