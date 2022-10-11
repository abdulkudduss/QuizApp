package com.example.quiz_lb1_v6;

public class Questions {
    private int question;
    private boolean isBtn_1,isBtn_2,isBtn_3,isBtn_4,isBtn_5,isBtn_6;

    public Questions(int question, boolean isBtn_1, boolean isBtn_2, boolean isBtn_3, boolean isBtn_4, boolean isBtn_5, boolean isBtn_6) {
        this.question = question;
        this.isBtn_1 = isBtn_1;
        this.isBtn_2 = isBtn_2;
        this.isBtn_3 = isBtn_3;
        this.isBtn_4 = isBtn_4;
        this.isBtn_5 = isBtn_5;
        this.isBtn_6 = isBtn_6;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isBtn_1() {
        return isBtn_1;
    }

    public void setBtn_1(boolean btn_1) {
        isBtn_1 = btn_1;
    }

    public boolean isBtn_2() {
        return isBtn_2;
    }

    public void setBtn_2(boolean btn_2) {
        isBtn_2 = btn_2;
    }

    public boolean isBtn_3() {
        return isBtn_3;
    }

    public void setBtn_3(boolean btn_3) {
        isBtn_3 = btn_3;
    }

    public boolean isBtn_4() {
        return isBtn_4;
    }

    public void setBtn_4(boolean btn_4) {
        isBtn_4 = btn_4;
    }

    public boolean isBtn_5() {
        return isBtn_5;
    }

    public void setBtn_5(boolean btn_5) {
        isBtn_5 = btn_5;
    }

    public boolean isBtn_6() {
        return isBtn_6;
    }

    public void setBtn_6(boolean btn_6) {
        isBtn_6 = btn_6;
    }
}
