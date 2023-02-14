package mx.mauriciogs.moviesandtvshows.lists.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.mauriciogs.moviesandtvshows.common.IMAGES_URL
import mx.mauriciogs.moviesandtvshows.databinding.MovieCardBinding
import mx.mauriciogs.moviesandtvshows.lists.movies.PlayingNowFragment
import mx.mauriciogs.storage.movies.data.models.Movie

class PlayingNowAdapter(private val movieList: List<Movie>, val frag: Fragment): RecyclerView.Adapter<PlayingNowAdapter.MovieViewHolder>() {


    class MovieViewHolder(val itemBinding: MovieCardBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(movie: Movie) {
            Glide.with(itemBinding.root.context)
                .load("$IMAGES_URL${movie.poster_path}")
                .centerCrop()
                .into(itemBinding.ivPoster)
            itemBinding.tvTitle.text = movie.title
            itemBinding.tvOverview.text = "Idioma: ${movie.original_language}"
            itemBinding.tvReleaseDate.text = movie.release_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(frag.requireActivity())
        val binding = MovieCardBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            if(frag is PlayingNowFragment) frag.onClickItem(movieList[position])
        }
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}