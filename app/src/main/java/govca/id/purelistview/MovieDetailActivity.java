package govca.id.purelistview;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import govca.id.purelistview.pojo.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Movie movie = getIntent().getParcelableExtra("Movie");

        TextView tv_name = findViewById(R.id.tv_movie_name_content);
        TextView tv_synopsis = findViewById(R.id.tv_movie_synopsis_content);
        TextView tv_director = findViewById(R.id.tv_movie_director_content);
        TextView tv_prod_house = findViewById(R.id.tv_prod_house_content);
        TextView tv_year = findViewById(R.id.tv_year_content);
        ImageView img_movie = findViewById(R.id.imgView_movie_poster_content);

        tv_name.setText(movie.getMovie_name());
        tv_synopsis.setText(movie.getSynopsis());
        tv_director.setText(movie.getDirector());
        tv_prod_house.setText(movie.getProduction_house());
        tv_year.setText(movie.getYear());
        String packageName = this.getPackageName();

        int identifier =  this
                .getResources()
                .getIdentifier(movie.getPoster(), "drawable", packageName);

        Glide
                .with(this)
                .load(identifier)
                .into(img_movie);

    }

}
