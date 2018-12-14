package com.example.qis_rnd.neoly;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.qis_rnd.neoly.View.TitleBar;
import com.example.qis_rnd.neoly.model.Medicine;
import com.example.qis_rnd.neoly.model.MedicineResponse;
import com.example.qis_rnd.neoly.model.Movie;
import com.example.qis_rnd.neoly.rest.ApiInterface;

import java.util.List;

import dimitrovskif.smartcache.BasicCaching;
import dimitrovskif.smartcache.SmartCall;
import dimitrovskif.smartcache.SmartCallFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {
//List<Movie> model;
    TitleBar titleBar;
//AndroidHive.
//int cacheSize = 10 * 1024 * 1024; // 10 MiB
//    RealmConfiguration realmConfiguration;
//    Realm realm;
    RecyclerView recyclerView;
//    public static final String BASE_URL = "http://192.168.90.73/kharismax/api/";
//    private static Retrofit retrofit = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    //  SmartCallFactory smartFactory = new SmartCallFactory(BasicCaching.fromCtx(this));
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FIND DOCTOR");
        setSupportActionBar(toolbar);
//        titleBar = (TitleBar) findViewById(R.id.titleBar);
//        titleBar.setTitle("FIND DOCTOR");
//        titleBar.showBack();

//        titleBar.setActionButtonBackClick(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });


        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        SwipeRefreshLayout swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipe);
//        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
//        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
//            @Override
//            public void onRefresh(){
                loadJSON();
                //Toast.makeText(MovieActivity.this, "Movies Refreshed", Toast.LENGTH_SHORT).show();
//            }
//        });



//       realm.init(getApplicationContext());
//     realmConfiguration = new RealmConfiguration.Builder().name("default0.realm").schemaVersion(3).build();
//       realm = Realm.getInstance(realmConfiguration);
//        Log.d("cek db","kosong");
//       RealmResults<Movie> movie = realm.where(Movie.class).findAll();
//       if (haveNetwork()//movie.load()
//         ){
//       if(movie.isEmpty()//haveNetwork()
//             ) {
        //  Log.d(TAG,"cekdata");
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<List<Movie>> call = apiService.getTopRatedMovies();
//        call.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//            SharedPreferences sharedPreferences =getSharedPreferences("shareprefmovie", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor= sharedPreferences.edit();
//                Gson gson=new Gson();
//
//                int statusCode = response.code();
//                List<Movie> movies = response.body();
//                String json =gson.toJson(movies);
//               // String json1 = sharedPreferences.getString("list1",null);
//               //Type type=new TypeToken<List<Movie>>(){}.getType();
//               //movies=gson.fromJson(json1,type);
//                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
//                editor .putString("list",json);
//                editor.apply();
////                if(movies==null){
////                    movies=new ArrayList<>();
////                }
//                // Log.d("mmn","cekdata");
////                    for (int i = 0; i < movies.size(); i++) {
////
////
////                        realm.beginTransaction();
////                        Movie _movie = realm.createObject(Movie.class);
//////                        realm.executeTransactionAsync(localRealm -> localRealm
//////                                        .where(Movie.class)
//////                                        .equalTo("id",_movie.getId())
//////                                        .findAll().deleteAllFromRealm(),
//////                                () -> realm.close(), error -> realm.close());
////                        _movie.setId(movies.get(i).getId());
//////                        _movie.setPosterPath(movies.get(i).getPosterPath());
//////                        _movie.setAdult(movies.get(i).isAdult());
//////                        _movie.setOverview(movies.get(i).getOverview());
//////                        _movie.setReleaseDate(movies.get(i).getReleaseDate());
//////                        _movie.setOriginalTitle(movies.get(i).getOriginalTitle());
//////                        _movie.setOriginalLanguage(movies.get(i).getOriginalLanguage());
////                        _movie.setTitle(movies.get(i).getTitle());
//////                        _movie.setBackdropPath(movies.get(i).getBackdropPath());
//////                        _movie.setPopularity(movies.get(i).getPopularity());
//////                        _movie.setVoteCount(movies.get(i).getVoteCount());
//////                        _movie.setVideo(movies.get(i).getVideo());
//////                        _movie.setVoteAverage(movies.get(i).getVoteAverage());
////                        _movie.setAge(movies.get(i).getAge());
////                        // realm.createOrUpdateAllFromJson(Movie.class, _movie.getTitle());
////                        //realm.deleteAll();
////                        realm.commitTransaction();
//////                        //I want to replace above.
////
//////
////                    }
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//                // Log error here since request failed
//                Log.e(TAG, t.toString());
//            }
//        });
////        }
////       } else {
////            Log.d("cek db","isi");
////            List<Movie> movies = movie;
////            recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
//////
////        }

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
        return have_MobileData||have_WIFI;
    }

//    SmartCallFactory smartFactory = new SmartCallFactory(BasicCaching.fromCtx(this));
//    public static Retrofit getClient() {
//
//        if (retrofit==null) {
//
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL).addCallAdapterFactory(smartFactory)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//private boolean isNetworkAvailable() {
//    ConnectivityManager connectivityManager
//            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//}
//
private void loadJSON(){
    SmartCallFactory smartFactory = new SmartCallFactory(BasicCaching.fromCtx(this));
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.90.66/medinfrasAPI/api/physician/")
            .addCallAdapterFactory(smartFactory)
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    ApiInterface apiService = retrofit.create(ApiInterface.class);
    SmartCall<MedicineResponse> call = apiService.getTopRatedMovies();
    call.enqueue(new Callback<MedicineResponse>() {
        @Override
        public void onResponse(Call<MedicineResponse> call, Response<MedicineResponse> response) {

            int statusCode = response.code();
            List<Medicine> movies = response.body().getResults();
            recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
//            // Log.d("mmn","cekdata");
//            for (int i = 0; i < movies.size(); i++) {
//
//
//                realm.beginTransaction();
//                Movie _movie = realm.createObject(Movie.class);
////                        realm.executeTransactionAsync(localRealm -> localRealm
////                                        .where(Movie.class)
////                                        .equalTo("id",_movie.getId())
////                                        .findAll().deleteAllFromRealm(),
////                                () -> realm.close(), error -> realm.close());
//                _movie.setId(movies.get(i).getId());
////                        _movie.setPosterPath(movies.get(i).getPosterPath());
////                        _movie.setAdult(movies.get(i).isAdult());
////                        _movie.setOverview(movies.get(i).getOverview());
////                        _movie.setReleaseDate(movies.get(i).getReleaseDate());
////                        _movie.setOriginalTitle(movies.get(i).getOriginalTitle());
////                        _movie.setOriginalLanguage(movies.get(i).getOriginalLanguage());
//                _movie.setTitle(movies.get(i).getTitle());
////                        _movie.setBackdropPath(movies.get(i).getBackdropPath());
////                        _movie.setPopularity(movies.get(i).getPopularity());
////                        _movie.setVoteCount(movies.get(i).getVoteCount());
////                        _movie.setVideo(movies.get(i).getVideo());
////                        _movie.setVoteAverage(movies.get(i).getVoteAverage());
//                _movie.setAge(movies.get(i).getAge());
//                // realm.createOrUpdateAllFromJson(Movie.class, _movie.getTitle());
//                //realm.deleteAll();
//                realm.commitTransaction();
////                        //I want to replace above.
//
////
//            }
        }

        @Override
        public void onFailure(Call<MedicineResponse> call, Throwable t) {
            // Log error here since request failed
            Log.e(TAG, t.toString());
        }
    });


    }
//    @Override
//    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s){
//        //Log.d(LOG_TAG, "Preferences updated");
//        checkSortOrder();
//    }
//    private void checkSortOrder(){
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//          loadJSON();
//
//    }


}
