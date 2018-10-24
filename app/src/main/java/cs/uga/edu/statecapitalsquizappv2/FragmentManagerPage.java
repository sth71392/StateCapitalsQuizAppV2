package cs.uga.edu.statecapitalsquizappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentManagerPage extends Fragment {

    public stateQuestionBank myStateQuestionLibrary = new stateQuestionBank();

    public TextView questionNumberTV;
    public TextView stateQuestion;
    public TextView scoreText;
    public RadioGroup radioGroup;
    public RadioButton choiceOne;
    public RadioButton choiceTwo;
    public RadioButton choiceThree;
    public Button submit;
    public Button viewResults;
    public int myQuestionNumber = 0;
    public String myAnswer;
    public static int score = 0;
    public static int counter = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manager, container, false);
        Bundle bundle = getArguments();
        int questionNumber = bundle.getInt("questionNumber");

        questionNumberTV = (TextView) view.findViewById(R.id.questionNumber);
        stateQuestion = (TextView) view.findViewById(R.id.stateQuestion);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        choiceOne = (RadioButton) view.findViewById(R.id.radioButton1);
        choiceTwo = (RadioButton) view.findViewById(R.id.radioButton2);
        choiceThree = (RadioButton) view.findViewById(R.id.radioButton3);
        submit = (Button) view.findViewById(R.id.submit);

        myStateQuestionLibrary.initialQuestions(getActivity().getApplicationContext());

        questionNumberTV.setText("Question " + Integer.toString(questionNumber));

        updateStateQuestion();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton1){
                    if(choiceOne.getText().equals(myAnswer)){
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                score++;
                                counter++;
                                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Correct " + score, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                    }else {
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                counter++;
                            }
                        });
                    }
                }else if(checkedId == R.id.radioButton2){
                    if(choiceTwo.getText().equals(myAnswer)){
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                score++;
                                counter++;
                                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Correct " + score, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                    }else {
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                counter++;
                            }
                        });
                    }
                }else if(checkedId == R.id.radioButton3){
                    if(choiceThree.getText().equals(myAnswer)){
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                score++;
                                counter++;
                                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Correct " + score, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                    }else {
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                submit.setEnabled(false);
                                counter++;
                            }
                        });
                    }
                }
            }
        });

        if(questionNumber == 7){
            view = inflater.inflate(R.layout.finished, container, false);
            viewResults = (Button) view.findViewById(R.id.viewResults);
            viewResults.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewResultsActivity();
                }
            });
        }

        return view;
    }

    public void updateStateQuestion(){
        if(myQuestionNumber < myStateQuestionLibrary.getLength()){
            stateQuestion.setText("Capital of " + myStateQuestionLibrary.getStateQuestion(myQuestionNumber) + "?");
            choiceOne.setText(myStateQuestionLibrary.getCapitalChoice(myQuestionNumber, 1));
            choiceTwo.setText(myStateQuestionLibrary.getCapitalChoice(myQuestionNumber, 2));
            choiceThree.setText(myStateQuestionLibrary.getCapitalChoice(myQuestionNumber, 3));
            myAnswer = myStateQuestionLibrary.getRightAnswer(myQuestionNumber);
            myQuestionNumber++;
        }
    }

    public void viewResultsActivity(){
        Intent intent = new Intent(getActivity(), ResultsActivity.class);
        intent.putExtra("results", String.valueOf(score));
        startActivity(intent);
    }
}
