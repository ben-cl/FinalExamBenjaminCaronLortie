package com.example.gsonpractice.data;

import com.example.gsonpractice.Model.DictionaryModel;
import com.example.gsonpractice.Model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {

    void processFinished(ArrayList<DictionaryModel> questionArrayList);

}
