package com.example.gsonpractice.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.gsonpractice.Model.DictionaryModel;
import com.example.gsonpractice.Model.Question;
import com.example.gsonpractice.controller.AppController;
import com.example.gsonpractice.data.AnswerListAsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {


    ArrayList<DictionaryModel> questionArrayList = new ArrayList<>();
    //private String url =  "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements.json";

    //private String url =  "https://my-json-server.typicode.com/cgerard321/dictionary/dictionary";
    private String url = "https://my-json-server.typicode.com/cgerard321/dictionary/dictionary";


    //AppController appController = new AppController();
    //RequestQueue requestQueue = appController.getRequestQueue();





    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }
    );


//    public  List<Question> getQuestionsTest() {
//
//        questionArrayList.add(new Question("Question 1 ", true));
//
//        questionArrayList.add(new Question("Question 2 ", true));
//
//        questionArrayList.add(new Question("Question 3 ", true));
//
//
//        return questionArrayList;
//
//
//    }

    public  List<DictionaryModel> getQuestions(final AnswerListAsyncResponse callBack){

        Log.d("getQuestions", "getQuestions: ");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,

                new Response.Listener<JSONArray>(){

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("json data", "onResponse: " +response);

                        //questionArrayList.Add(" ", " ");

                        for(int i=0; i<response.length(); i++) {


                            try {

                                //JSONArray jsonArray = response.getJSONArray();

                                DictionaryModel dictionaryModel = new DictionaryModel();

                                dictionaryModel.setWord(response.getJSONObject(i).getString("word"));

                                dictionaryModel.setPos(response.getJSONObject(i).getString("pos"));
                                dictionaryModel.setDefinition(response.getJSONObject(i).getString("definition"));
                                dictionaryModel.setFrench(response.getJSONObject(i).getString("french"));


                                //questionObject.setAnswerTrue(response.getJSONArray(i).getBoolean(1));
//                                questionObject.setAnswer(response.getJSONArray(i).getJSONObject(0).toString());


                                questionArrayList.add(dictionaryModel);

                                Log.d("json data", "onResponse: " + response.getJSONArray(1).get(0));
                                Log.d("json data", "onResponse: " + response.getJSONArray(1).get(1));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                        if(null != callBack) callBack.processFinished(questionArrayList);
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){


            }


        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }



    /*
    public void onResponse(JSONArray response){

        try{
            for(int i = 0; i<response.length(); i++){
                Question question = new Question();
                question.setAnswer(response.getJSONArray(i).getString(0));
                question.setAnswerTrue(response.getJSONArray(i).getString(1));
                questionArrayList.add(question);
            }
            catch(JSONException e){

                printStackTrace();

            }
        }
    }

*/



}
