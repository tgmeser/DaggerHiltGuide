package com.babyapps.hiltguide.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.math.BigInteger
import java.util.ArrayList
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Singleton component cuz of Application scope
object AppModule {
    //The modules are just like AppModule work as container for dependencies
    //The dependencies stay alive as long as Application class does
    //Other hand if we switch among activities, F.E. main activity injections cant be moved into another

    @Singleton //Singleton annotations for that we use SingletonComponent in InstallIn
    @Provides
    @Named("StringType1")
    fun provideStrings(): String = "...String Injection from AppModule..."

    @Singleton //Singleton annotations for that we use SingletonComponent in InstallIn
    @Provides
    fun provideArrays(): Array<String> = arrayOf("---Array Injection from AppModule---")


    //The point of same return types of provide methods
    //The meaning what if we want different results on same return type
    //We should name annotation above provide methods to make hilt recognize them

    @Singleton //Singleton annotations for that we use SingletonComponent in InstallIn
    @Provides
    @Named("Arraylist_Type1")
    fun provideArrayListString1(): ArrayList<String> = arrayListOf(":::Type 1:::")


    @Singleton //Singleton annotations for that we use SingletonComponent in InstallIn
    @Provides
    @Named("Arraylist_Type2")
    fun provideArrayListString2(): ArrayList<String> = arrayListOf(":::Type 2:::")


}
