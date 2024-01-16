package com.biggerthannull.plumbbristol.data.di

import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
class FirestoreModule {

    @Provides
    fun provideFireStore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Named("BATHROOMS")
    fun provideBathroomsCollection(firestore: FirebaseFirestore): CollectionReference {
        return firestore.collection("bathrooms")
    }
}