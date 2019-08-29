package govca.id.purelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import govca.id.purelistview.pojo.Movie;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    ListView listView_movies;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String moviesArray = this.fromFile("movies.json");

        listView_movies = findViewById(R.id.listView_movies);

        try {
            Movie[] movies = mapper.readValue(moviesArray, Movie[].class);

            ArrayList<Movie> movieArrayList = new ArrayList<>();

            for (int i=0; i<movies.length; i++)
            {
                Log.d(TAG, movies[i].getMovie_name());
                Log.d(TAG, movies[i].getYear());
                movieArrayList.add(movies[i]);
            }

            MovieAdapter customAdapter = new MovieAdapter(getApplicationContext(), movieArrayList);
            listView_movies.setAdapter(customAdapter);

            listView_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Movie movie = (Movie) parent.getItemAtPosition(position);
                    Log.d(TAG, "You are selecting " + movie.getMovie_name());

                    Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                    intent.putExtra("Movie", movie);
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public String fromFile(String fileName)
    {
        String json ;
        try {
            InputStream is = this.getApplicationContext().getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage());
            return null;
        }
        return json;
    }
}
