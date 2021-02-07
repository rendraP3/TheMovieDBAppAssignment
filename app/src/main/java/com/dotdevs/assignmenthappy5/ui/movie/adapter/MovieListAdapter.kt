package com.dotdevs.assignmenthappy5.ui.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dotdevs.assignmenthappy5.base.GlideApp
import com.dotdevs.assignmenthappy5.databinding.MovieItemBinding
import com.dotdevs.assignmenthappy5.model.dto.movie.MovieDto
import com.dotdevs.assignmenthappy5.utils.setPosterImage

class MovieListAdapter(
    private val listener: MovieItemListener
) : RecyclerView.Adapter<MovieItemViewHolder>() {

    interface MovieItemListener {
        fun onClickedMovie(movieId: Int)
    }

    private val items = ArrayList<MovieDto>()

    fun setItems(items: ArrayList<MovieDto>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding: MovieItemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return MovieItemViewHolder(binding, listener)
    }

    override fun getItemCount() : Int = if (!items.isNullOrEmpty()) 10 else 0

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) = holder.bind(items[position])

}

class MovieItemViewHolder(
    private val binding: MovieItemBinding,
    private val listener: MovieListAdapter.MovieItemListener,
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var movie: MovieDto

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(movie: MovieDto) {
        this.movie = movie

        binding.movieTitle.text = movie.title
        movie.posterPath?.let {
            binding.movieImg.setPosterImage(movie.posterPath)
        }

        binding.movieRating.text = if (movie.voteAverage == 0.0) "N/A"
        else movie.voteAverage.toString()
    }

    override fun onClick(v: View?) {
        listener.onClickedMovie(movie.id!!)
    }

}