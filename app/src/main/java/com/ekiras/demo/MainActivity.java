package com.ekiras.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.ekiras.demo.adapter.PersonAdapter;
import com.ekiras.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private int bootCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PersonAdapter personAdapter = new PersonAdapter(this,bootData());
        listView = (ListView) findViewById(R.id.person_list);
        listView.setAdapter(personAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem+visibleItemCount > totalItemCount-2){
                    personAdapter.add(bootData());
                    personAdapter.notifyDataSetChanged();
                }
            }
        });
    }



    private List<Person> bootData(){
        List<Person> persons = new ArrayList<Person>();
        for(int i=bootCounter;i<bootCounter+20;i++){
            Person person = new Person();
            person.setName("person-" + i);
            person.setDesc("description :" + i);
            person.setEmail("person" + i + "@ekiras.com");
            person.setImage(R.drawable.user);
            persons.add(person);
        }
        bootCounter+=20;
        return persons;
    }
}
