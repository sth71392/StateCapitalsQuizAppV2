package cs.uga.edu.statecapitalsquizappv2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentManagerPage extends Fragment {

    public TextView questionNumberTV;
    public TextView stateQuestion;
    public Button choiceOne;
    public Button choiceTwo;
    public Button choiceThree;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manager, container, false);
        Bundle bundle = getArguments();
        int questionNumber = bundle.getInt("questionNumber");

        questionNumberTV = (TextView) view.findViewById(R.id.questionNumber);
        stateQuestion = (TextView) view.findViewById(R.id.stateQuestion);
        choiceOne = (Button) view.findViewById(R.id.choiceOne);
        choiceTwo = (Button) view.findViewById(R.id.choiceTwo);
        choiceThree = (Button) view.findViewById(R.id.choiceThree);



        questionNumberTV.setText(Integer.toString(questionNumber));

        return view;
    }

}
