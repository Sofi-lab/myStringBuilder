package com.example.myStringBuilder;

import lombok.Getter;

import java.util.Stack;

@Getter
public class MyStringBuilder {

    private Stack<String> stack;
    private StringBuilder builder;

    public MyStringBuilder() {
        this.stack = new Stack<>();
        this.builder = new StringBuilder();
    }

    public MyStringBuilder append(String str) {
        saveStack(str);
        builder.append(str);
        return this;
    }

    private void saveStack(String string) {
        stack.push(string);
    }

    public void undo() {
        if (stack.size() > 1) {
            stack.pop();
            builder = new StringBuilder(stack.peek());
        } else {
            builder = new StringBuilder();
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public static void main(String[] args) {
        MyStringBuilder build = new MyStringBuilder();
        build.append(" Первая строка");
        build.undo();
        System.out.println(build);
        build.append(" Вторая строка, ");
        build.append(" Третья строка,");
        System.out.println(build);

        build.undo();
        System.out.println(build);
    }
}
