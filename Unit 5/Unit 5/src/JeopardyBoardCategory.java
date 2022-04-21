import java.util.ArrayList;

public class JeopardyBoardCategory {
    private ArrayList<JeopardyQuestion> questions = new ArrayList<JeopardyQuestion>();
    private String category;

    public JeopardyBoardCategory(String category, JeopardyQuestion[] questions) {
        this.category = category;
        for (JeopardyQuestion ques : questions) {
            this.questions.add(ques);
        }

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