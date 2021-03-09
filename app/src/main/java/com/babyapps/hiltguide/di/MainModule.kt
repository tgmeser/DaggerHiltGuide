package com.babyapps.hiltguide.di

import android.content.Context
import com.babyapps.hiltguide.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named


@Module
@InstallIn(ActivityComponent::class) //Activitycomponent cuz of it ll be used in Mainactivity
object MainModule {

    //We use injections that belongs here, in main activity, focus the point !
    //The point is we limit injections through Scope types above provide methods !
    //There for we can configure them to activities, fragments,viewmodels, views ...

    @ActivityScoped //We can not use Singleton, we work on activitycomponent right now
    @Provides
    @Named("StringType2")
    fun provideStrings2(
        @ApplicationContext context: Context,
        @Named("StringType1") str: String
    ): String =
        "${context.getString(R.string.string2di)} -connection- $str"
    //The point in this method;
    //Hilt recognizes Named annotation belongs to str parameter
    //which comes from the method uses same Name("value")
    //Therefore hilt creates a bridge among them
    //The meaning we use a injected string in provideString2 method and string come from appmodule
    //And through context parameter, we want to access a string from R.string directory

}
