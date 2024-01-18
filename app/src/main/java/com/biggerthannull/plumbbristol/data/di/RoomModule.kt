package com.biggerthannull.plumbbristol.data.di

import android.content.Context
import androidx.room.Room
import com.biggerthannull.plumbbristol.data.database.room.BookmarksDatabase
import com.biggerthannull.plumbbristol.data.database.room.dao.BookmarksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideBookmarksDatabase(
        context: Context
    ): BookmarksDatabase {
        return Room.databaseBuilder(
            context,
            BookmarksDatabase::class.java,
            "BookmarkedBathrooms"
        ).build()
    }

    @Provides
    fun provideBookmarksDao(database: BookmarksDatabase): BookmarksDao {
        return database.dao()
    }
}