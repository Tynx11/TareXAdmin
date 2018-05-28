package com.valdo.tarex.tarexadmin.ui.requests;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.valdo.tarex.tarexadmin.R;
import com.valdo.tarex.tarexadmin.model.requests.Reservations;
import com.valdo.tarex.tarexadmin.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.valdo.tarex.tarexadmin.utils.Constants.ID_KEY;

public class RequestListActivity extends BaseActivity implements RequestListView {

    Boolean falg1 = false;

    protected static final String LOG_TAG = "my_tag";
    TabHost.TabSpec tabSpec;

    @InjectPresenter
    RequestListPresenter presenter;

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    private RequestListAdapter adapter;
    private RequestListAdapter adapter2;

    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        id = getIntent().getLongExtra(ID_KEY,0);


        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Заявки");
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);


        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("История");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);



        presenter.getRequest(id);
        presenter.getRequestActive(id);

        initRecycler();
        initRecycler2();



    }

    @Override
    public void handleError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("Alm", error.getMessage());
        error.printStackTrace();
    }

    @Override
    public void showItems(@NonNull List<Reservations> items) {
        adapter.changeDataSet(items);
    }

    @Override
    public void showItems2(@NonNull List<Reservations> items) {
        adapter2.changeDataSet(items);
    }


    private void initRecycler() {
        recyclerView = findViewById(R.id.rv_all);
        adapter = new RequestListAdapter(new ArrayList<>());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);

    }

    private void initRecycler2() {
        recyclerView2 = findViewById(R.id.rv_active);
        adapter2 = new RequestListAdapter(new ArrayList<>());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(manager);
        recyclerView2.setHasFixedSize(true);
        adapter2.attachToRecyclerView(recyclerView2);
        recyclerView2.setAdapter(adapter2);

    }
}
