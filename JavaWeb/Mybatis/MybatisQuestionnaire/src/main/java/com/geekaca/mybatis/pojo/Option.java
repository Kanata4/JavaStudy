package com.geekaca.mybatis.pojo;

public class Option extends Question{
    private String optionContent;

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    @Override
    public String toString() {
        return "Option{" +
                "content='" + this.getContent() +
                "optionContent='" + optionContent + '\'' +
                '}';
    }
}
