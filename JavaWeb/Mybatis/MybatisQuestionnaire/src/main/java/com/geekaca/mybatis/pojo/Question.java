package com.geekaca.mybatis.pojo;

public class Question extends Questionnaire{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                '}';
    }
}
