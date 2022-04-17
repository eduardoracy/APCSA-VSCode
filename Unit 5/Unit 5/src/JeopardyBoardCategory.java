public class JeopardyBoardCategory {
    private JeopardyQuestion[] questions = new JeopardyQuestion[5];
    private String category;

    public JeopardyBoardCategory(String category, JeopardyQuestion twoHundred, JeopardyQuestion fourHundred,
            JeopardyQuestion sixHundred, JeopardyQuestion eightHundred, JeopardyQuestion oneThousand) {
        this.category = category;
        questions[0] = twoHundred;
        questions[1] = fourHundred;
        questions[2] = sixHundred;
        questions[3] = eightHundred;
        questions[4] = oneThousand;
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
        return questions[(value/200) - 1];
    }

    public String getCategory() {
        return category;
    }

}