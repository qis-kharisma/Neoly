package com.example.qis_rnd.neoly;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.qis_rnd.neoly.ModelGetRetro.adapter.FlowersAdapter;
import com.example.qis_rnd.neoly.ModelGetRetro.pojo.Flower;
import com.example.qis_rnd.neoly.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class GetCardActivity extends AppCompatActivity  implements Controller.FlowerCallbackListener {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Flower> mFlowerList = new ArrayList<>();
    private FlowersAdapter mFlowersAdapter;
    private Controller mController;
    private SearchView sv;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedPrefs;

    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_card);
//        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);
//        final FlowersAdapter adapter=new FlowersAdapter(this,getPlayers());
//        mRecyclerView.setAdapter(adapter);
        //SEARCH
//        sharedPrefs = getSharedPreferences(GetCardActivity.MyPREFERENCES,
//                Context.MODE_PRIVATE);//sharepreferences;
//        editor = sharedPrefs.edit();
//        realm.init(getApplicationContext());
//        realmConfiguration = new RealmConfiguration.Builder().build();
//        realm = Realm.getInstance(realmConfiguration);
//        RealmResults<Flower> movie = realm.where(Flower.class).findAll();

        configToolbar();
        mController = new Controller(GetCardActivity.this);
        configViews();
        mController.startFetching();

    }
    private void configToolbar() {
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipe);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(com.example.qis_rnd.neoly.GetCardActivity.this));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        sv= (SearchView) findViewById(R.id.mSearch);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                mFlowersAdapter.getFilter().filter(query);
                return false;
            }
        });
        mFlowersAdapter = new FlowersAdapter(mFlowerList);
        mRecyclerView.setAdapter(mFlowersAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                 //mController.startFetching();
            }
        });

        //addFlowers();
    }

    private void addFlowers() {
        for(int i = 0; i  < 1000; i++) {

            Flower flower = new Flower.Builder()
                    .setName("Filippo")
                    .setPrice(32)
                    //  .setPhoto("AJHAJKS")
                    .build();

            mFlowersAdapter.addFlower(flower);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main9, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Flower flower) {
        mFlowersAdapter.addFlower(flower);
    }

    @Override
    public void onFetchProgress(List<Flower> flowerList) {

    }

    @Override
    public void onFetchComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFetchFailed() {

    }
    private boolean haveNetwork(){
        boolean have_WIFI=false;
        boolean have_MobileData=false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] netinfos= connectivityManager.getAllNetworkInfo();
        for( NetworkInfo info:netinfos){
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI=true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData=true;

        }
        return have_MobileData||have_WIFI;}
}
