import java.util.ArrayList;

public class JeopardyBoardCategory {
    private ArrayList<JeopardyQuestion> questions = new ArrayList<JeopardyQuestion>(5);
    private String category;

    public JeopardyBoardCategory(String category, JeopardyQuestion twoHundred, JeopardyQuestion fourHundred,
            JeopardyQuestion sixHundred, JeopardyQuestion eightHundred, JeopardyQuestion oneThousand) {
        this.category = category;
        questions.set(0, twoHundred);
        questions.set(1, fourHundred);
        questions.set(2, sixHundred);
        questions.set(3, eightHundred);
        questions.set(4, oneThousand);
    }

    public boolean allCategoryQuestionsAnswered() {
        for (JeopardyQuestion question : questions) {
            if (!question.isAnswered()) {
                return false;
            }
        }
        return true;
    }

    public JeopardyQuestion categoryQuestion(int value) {
        return questions.get((value/200) - 1);
    }

    public String getCategory() {
        return category;
    }

}