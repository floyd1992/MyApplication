package jyqqhw.com.recyclerviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private CheckAnimRecyclerAdapter adapter;
    private List<String> list = new ArrayList<>();
    private Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBtn();
    }

    private void initBtn(){
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!= adapter){
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void init(){

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        initData(80);
        adapter = new CheckAnimRecyclerAdapter(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }


    private void initData(int num) {
        list.clear();
        for (int i = 1; i < num; i++) {
            list.add("第 " + i + " 项数据");
        }
    }



}
