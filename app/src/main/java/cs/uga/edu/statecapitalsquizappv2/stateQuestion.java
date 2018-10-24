package cs.uga.edu.statecapitalsquizappv2;

public class stateQuestion {

    private String question;
    private String[] capitalChoice = new String[3];
    private String answer;

    public stateQuestion(){

    }

    public stateQuestion(String question, String[] capitalChoices, String answer){
        this.question = question;
        this.capitalChoice[0] = capitalChoices[0];
        this.capitalChoice[1] = capitalChoices[1];
        this.capitalChoice[2] = capitalChoices[2];
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getCapitalChoice(int index){
        return capitalChoice[index];
    }

    public void setCapitalChoice(int index, String choice){
        this.capitalChoice[index] = choice;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

}
