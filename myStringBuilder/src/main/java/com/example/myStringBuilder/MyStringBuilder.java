package com.example.myStringBuilder;

import lombok.Getter;

import java.util.Stack;

@Getter
public class MyStringBuilder {

    private Stack<String> stack;
    private StringBuilder builder;

    public MyStringBuilder() {
        this.builder = new StringBuilder();
        this.stack = new Stack<>();
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
            String previousPos = stack.peek();
            builder = new StringBuilder(previousPos);
        } else {
            throw new RuntimeException("This is start state");
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public static void main(String[] args) {
        MyStringBuilder build = new MyStringBuilder();
        build.append(" firstAdd,");
        build.append(" secondAdd,");

        build.undo();
        build.append(" third append");

        System.out.println(build);
    }
}
