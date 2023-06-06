package hjnu.wl.SchoolServerTools.model;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:06

/**
 * @author wule
 * 疑难解答
 */
public class Question
{
    private String questionId;  //问题id
    private String question;    //问题
    private String answer;      //答案
    private String quizzerId;   //提问者id
    private String answererId;  //回答者id
    private String releaseTime; //发布时间
    private String answerTime;  //回答时间
    private String state;       //状态

    public Question() {}

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuizzerId() {
        return quizzerId;
    }

    public void setQuizzerId(String quizzerId) {
        this.quizzerId = quizzerId;
    }

    public String getAnswererId() {
        return answererId;
    }

    public void setAnswererId(String answererId) {
        this.answererId = answererId;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
