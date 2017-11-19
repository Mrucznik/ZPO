import java.util.LinkedList;

public class Question {
    private String question;
    private LinkedList<String> answers;
    private boolean correct;

    public Question(String question, LinkedList<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public void answer(String answer) {
        if(answers.contains(answer.toLowerCase())) {
            correct = true;
        } else {
            correct = false;
        }
    }
}
