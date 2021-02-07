package com.dotdevs.assignmenthappy5.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dotdevs.assignmenthappy5.databinding.FragmentMovieBinding
import com.dotdevs.assignmenthappy5.ui.movie.adapter.MovieListAdapter
import com.dotdevs.assignmenthappy5.ui.movie.adapter.UpcomingMovieListAdapter
import com.dotdevs.assignmenthappy5.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieListAdapter.MovieItemListener, UpcomingMovieListAdapter.UpcomingItemListener {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var nowPlayingAdapter: UpcomingMovieListAdapter
    private lateinit var popularAdapter: MovieListAdapter
    private lateinit var topRatedAdapter: MovieListAdapter
    private lateinit var upcomingAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        nowPlayingAdapter = UpcomingMovieListAdapter(this)
        popularAdapter = MovieListAdapter(this)
        topRatedAdapter = MovieListAdapter(this)
        upcomingAdapter = MovieListAdapter(this)

        binding.nowPlayingMovieList.adapter = nowPlayingAdapter
        binding.popularMovieList.adapter = popularAdapter
        binding.topRatedMovieList.adapter = topRatedAdapter
        binding.upcomingMovieList.adapter = upcomingAdapter
    }

    private fun setupObservers() {
        viewModel.nowPlayingMovies.observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    if (!it.data?.results.isNullOrEmpty()) nowPlayingAdapter.setItems(ArrayList(it.data?.results))
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.popularMovies.observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    if (!it.data?.results.isNullOrEmpty()) popularAdapter.setItems(ArrayList(it.data?.results))
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.topRatedMovies.observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    if (!it.data?.results.isNullOrEmpty()) topRatedAdapter.setItems(ArrayList(it.data?.results))
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.upcomingMovies.observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    if (!it.data?.results.isNullOrEmpty()) upcomingAdapter.setItems(ArrayList(it.data?.results))
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onClickedMovie(movieId: Int) {
        findNavController()
    }

}