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
        saveStack(this.builder.toString());
        builder.append(str);
        return this;
    }

    private void saveStack(String string) {
        stack.push(string);
    }

    public void undo() {
        if (stack.size() > 1) {
            builder = new StringBuilder(stack.pop());
        } else {
            builder = new StringBuilder();
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    public static void main(String[] args) {
        MyStringBuilder a = new MyStringBuilder();
        a.append("test,");
        a.append("test,");
        a.append("test,");
        a.append("test,");
        a.undo();
        System.out.println(a);
    }
}
