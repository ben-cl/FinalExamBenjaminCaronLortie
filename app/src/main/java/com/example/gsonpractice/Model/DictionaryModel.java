package com.example.gsonpractice.Model;

import java.io.Serializable;

public class DictionaryModel implements Serializable {

    private String word;
    private String pos;
    private String definition;
    private String french;

    public DictionaryModel(String word, String pos, String definition, String french) {
        this.word = word;
        this.pos = pos;
        this.definition = definition;
        this.french = french;
    }

    public DictionaryModel() {
    }

    public String getWord() {
        return word;
    }

    public String getPos() {
        return pos;
    }

    public String getDefinition() {
        return definition;
    }

    public String getFrench() {
        return french;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
