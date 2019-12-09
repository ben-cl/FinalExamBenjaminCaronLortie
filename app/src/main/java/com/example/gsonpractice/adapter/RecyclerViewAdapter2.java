package com.example.gsonpractice.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gsonpractice.French;
import com.example.gsonpractice.R;

import com.example.gsonpractice.Definition;
import com.example.gsonpractice.Model.DictionaryModel;
//import com.example.grocerystore.EditStore;
//import com.example.grocerystore.ItemList;
//import com.example.grocerystore.MainActivity;
//import com.example.grocerystore.R;
//import com.example.grocerystore.data.DatabaseHandler;
//import com.example.grocerystore.model.Store;
//
//import java.util.Dictionary;
import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {

    private Context context;
    private List<DictionaryModel> dictionaryList;

    //<Store> storeList)
    public RecyclerViewAdapter2(Context context,  List<DictionaryModel> dictionaryList) {
        this.context = context;
        this.dictionaryList = dictionaryList;
    }

    //Context context;

//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        context = recyclerView.getContext();
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_word_row,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //final DatabaseHandler db = new DatabaseHandler(context);



        final DictionaryModel dictionary = dictionaryList.get(position);

        holder.name.setText(dictionary.getWord());

        //Call remove method
        holder.defineButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d("testing", "onClick: remove button");
                //db.deleteContact(dictionary);

                // Launch back menu
                Intent intent = new Intent(context, Definition.class);

                intent.putExtra("dictionary",dictionary);

                context.startActivity(intent);
            }
        });

        //Call french button
        holder.frenchButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d("testing", "onClick: remove button");
                //db.deleteContact(dictionary);

                // Launch back menu
                Intent intent = new Intent(context, French.class);

                intent.putExtra("dictionary",dictionary);

                context.startActivity(intent);
            }
        });


//        // Call edit method
//        holder.editButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//
//                Intent intent = new Intent(context, EditStore.class);
//                // pass store
//                intent.putExtra("store", dictionary);
//
//                context.startActivity(intent);
//
//
//            }
//        });
        //holder.phoneNumber.setText(contact.getPhoneNumber());


    }



    @Override
    public int getItemCount() {
        return dictionaryList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private Button defineButton;
        private Button frenchButton;
        //private TextView phoneNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.store_name);
            defineButton = itemView.findViewById(R.id.defineButton);
            frenchButton = itemView.findViewById(R.id.frenchButton);
            //phoneNumber = itemView.findViewById(R.id.phone_number);


        }


        @Override
        public void onClick(View v) {

//            int position = getAdapterPosition();
//            Store dictionary = storeList.get(position);
//            Log.d("Clicked", "onClick: "+position);
//
//            Intent intent = new Intent(context, ItemList.class);
//            intent.putExtra("store",dictionary);
//            //intent.putExtra("phone", contact.getPhoneNumber());
//
//            // pass id instead?
//
//
//            context.startActivity(intent);
        }


    }

}
