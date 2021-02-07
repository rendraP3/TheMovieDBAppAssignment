//package com.dotdevs.assignmenthappy5.di
//
//import android.content.Context
//import com.dotdevs.assignmenthappy5.local.AppDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object LocalModule {
//
//    @Provides
//    @Singleton
//    fun privateDatabase(
//        @ApplicationContext context: Context
//    ) = AppDatabase.getDatabase(context)
//
//    @Provides
//    @Singleton
//    fun provideMovieDao(
//        db: AppDatabase
//    ) = db.movieDao()
//
//}