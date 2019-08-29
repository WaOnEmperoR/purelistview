package govca.id.purelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import govca.id.purelistview.pojo.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
    ArrayList<Movie> movieArrayList = new ArrayList<>();

    public MovieAdapter(@NonNull Context context, ArrayList<Movie> items) {
        super(context, 0, items);
        this.movieArrayList = items;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.movie_item, null);

        ImageView imageView = v.findViewById(R.id.img_movie_poster);
        TextView tv_movie_name = v.findViewById(R.id.tv_movie_name);
        TextView tv_prod_house_name = v.findViewById(R.id.tv_prod_house_name);
        TextView tv_director_name = v.findViewById(R.id.tv_director_name);
        TextView tv_year = v.findViewById(R.id.tv_year);

        tv_movie_name.setText(movieArrayList.get(position).getMovie_name());
        tv_prod_house_name.setText(movieArrayList.get(position).getProduction_house());
        tv_director_name.setText(movieArrayList.get(position).getDirector());
        tv_year.setText(movieArrayList.get(position).getYear());

        String packageName = getContext().getPackageName();

        int identifier = getContext()
                .getResources()
                .getIdentifier(movieArrayList.get(position).getPoster(), "drawable", packageName);

        Glide
                .with(getContext())
                .load(identifier)
                .into(imageView);

        return v;
    }
}
