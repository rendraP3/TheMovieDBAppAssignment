package com.dotdevs.assignmenthappy5.network.api.movie

import com.dotdevs.assignmenthappy5.network.api.BaseDataSource
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieApiService: MovieApiService
) : BaseDataSource() {



}