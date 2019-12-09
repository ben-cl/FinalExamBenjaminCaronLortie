package com.example.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gsonpractice.Model.Car;
import com.example.gsonpractice.Model.DictionaryModel;
import com.example.gsonpractice.Model.Question;
import com.example.gsonpractice.adapter.RecyclerViewAdapter;
import com.example.gsonpractice.adapter.RecyclerViewAdapter2;
import com.example.gsonpractice.data.AnswerListAsyncResponse;
import com.example.gsonpractice.data.QuestionBank;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private TextView textView;
    private TextView textViewTest;

    private List<DictionaryModel> questionList;
    private RequestQueue mQueue;

    private RecyclerView recyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;

    //private RecyclerView recyclerView;
    public RecyclerViewAdapter2 recyclerViewAdapter2;


    private ArrayList<DictionaryModel> questionArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));




        //mQueue = Volley.newRequestQueue(this);

        Car car = new Car("Versa", 20000);

        //Contact contact = contactList.get(position);
        Gson gson = new Gson();
        String carAsString = gson.toJson(car);

//        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//        intent.putExtra("ContactAsString", carAsString);
//        startActivity(intent);

//textQuestion
//        Log.d("test json", "processFinished: tset ");




        questionArrayList = new ArrayList<>();



        questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {

            @Override
            public void processFinished(ArrayList<DictionaryModel> questionArrayList) {


              setRecyclerView();
            }
        });

//        questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
//
//
//            @Override
//            public void processFinished(ArrayList<Question> questionArrayList) {
//
//                //textViewTest.setText(questionArrayList.get(3).getAnswer());
//               // Log.d("test json", "processFinished: "+questionArrayList.get(5).getAnswer());
//            }
//
//
//        });

        //textViewTest.setText(questionList.get(1).getAnswer());
        //textView2.findViewById(R.id.textQuestion);

        //mQueue = Volley.newRequestQueue(this);


       // Toast.makeText(getApplicationContext(), "Test "+questionList.get(1).getWord(), Toast.LENGTH_LONG).show();

       // Toast.makeText(getApplicationContext(), "Test ", Toast.LENGTH_LONG).show();



//    jsonParse();


    }
    private void setRecyclerView(){
        for(DictionaryModel store: questionList) {
            //Log.d("test list", "onCreate: " + store.getName());
            //Log.d("test list", "onCreate: " + contact.getPhoneNumber());
            Log.d("test list", "onCreate: " + store.getWord());

            questionArrayList.add(store);


        }

        recyclerViewAdapter2 = new RecyclerViewAdapter2(MainActivity.this, questionArrayList);
        recyclerView.setAdapter(recyclerViewAdapter2);

    }

    private void jsonParse() {

        String url = "https://api.myjson.com/bins/kp9wz";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                textViewTest.setText(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");

                                Log.d("test vid", "onResponse: "+firstName);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
