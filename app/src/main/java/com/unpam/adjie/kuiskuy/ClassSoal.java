/**
 * Created by Adjie on 04/10/17.
 */

package com.unpam.adjie.kuiskuy;

public class ClassSoal {

    private String question;
    private String answer;
    private String realAnswer;
    private Boolean isCorrect;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setRealAnswer(String answer) {
        this.realAnswer = answer;
    }

    public String getRealAnswer() {
        return realAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        if (this.answer.equals(this.realAnswer))
        {
            this.isCorrect = true;
        } else {
            this.isCorrect = false;
        }
        return isCorrect;
    }

    public void isCorrect() {
        if (this.answer.equals(this.realAnswer))
        {
            this.isCorrect = true;
        } else {
            this.isCorrect = false;
        }
    }


}
