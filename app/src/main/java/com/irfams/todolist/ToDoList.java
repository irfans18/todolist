package com.irfams.todolist;

public class ToDoList {
    private String titledoes, descdoes, datedoes;

    public ToDoList() {
    }

    public ToDoList(String titledoes, String descdoes, String datedoes) {
        this.titledoes = titledoes;
        this.descdoes = descdoes;
        this.datedoes = datedoes;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }
}
