public class JeopardyBoard {
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[5];

    public JeopardyBoard(JeopardyBoardCategory category1, JeopardyBoardCategory category2,
            JeopardyBoardCategory category3,
            JeopardyBoardCategory category4, JeopardyBoardCategory category5) {
        categories[0] = category1;
        categories[1] = category2;
        categories[2] = category3;
        categories[3] = category4;
        categories[4] = category5;
    }

    public JeopardyBoard createBoard() {
        return new JeopardyBoard(
        new JeopardyBoardCategory(category, 
            new JeopardyQuestion(question, answer, answerFormat, 200, false), 
            new JeopardyQuestion(question, answer, answerFormat, 400, false), 
            new JeopardyQuestion(question, answer, answerFormat, 600, false), 
            new JeopardyQuestion(question, answer, answerFormat, 800, false), 
            new JeopardyQuestion(question, answer, answerFormat, 1000, false)
        ), 

        new JeopardyBoardCategory(category, 
            new JeopardyQuestion(question, answer, answerFormat, 200, false), 
            new JeopardyQuestion(question, answer, answerFormat, 400, false), 
            new JeopardyQuestion(question, answer, answerFormat, 600, false), 
            new JeopardyQuestion(question, answer, answerFormat, 800, false), 
            new JeopardyQuestion(question, answer, answerFormat, 1000, false)
        ), 

        new JeopardyBoardCategory(category, 
            new JeopardyQuestion(question, answer, answerFormat, 200, false), 
            new JeopardyQuestion(question, answer, answerFormat, 400, false), 
            new JeopardyQuestion(question, answer, answerFormat, 600, false), 
            new JeopardyQuestion(question, answer, answerFormat, 800, false), 
            new JeopardyQuestion(question, answer, answerFormat, 1000, false)
        ), 

        new JeopardyBoardCategory(category, 
            new JeopardyQuestion(question, answer, answerFormat, 200, false), 
            new JeopardyQuestion(question, answer, answerFormat, 400, false), 
            new JeopardyQuestion(question, answer, answerFormat, 600, false), 
            new JeopardyQuestion(question, answer, answerFormat, 800, false), 
            new JeopardyQuestion(question, answer, answerFormat, 1000, false)
        ), 

        new JeopardyBoardCategory(category, 
            new JeopardyQuestion(question, answer, answerFormat, 200, false), 
            new JeopardyQuestion(question, answer, answerFormat, 400, false), 
            new JeopardyQuestion(question, answer, answerFormat, 600, false), 
            new JeopardyQuestion(question, answer, answerFormat, 800, false), 
            new JeopardyQuestion(question, answer, answerFormat, 1000, false)
        )
        
        );
    }

    
}