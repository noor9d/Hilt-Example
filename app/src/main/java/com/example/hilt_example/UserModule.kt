package com.example.hilt_example

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
//@InstallIn(FragmentComponent::class) // using UserRepository module in Fragment
@InstallIn(ActivityComponent::class) // using UserRepository module in Activity
//@InstallIn(SingletonComponent::class) // using UserRepository module in Application
class UserModule {

    @Provides
    @Named("sql") // predefined qualifier
    fun providesSqlRepository(sqlRepository: SQLRepository): UserRepository {
        return sqlRepository
    }

    @Provides
    @FirebaseQualifier // user-defined qualifier
    fun providesUserRepository(): UserRepository {
        return FirebaseRepository()
    }

    // Inject interface instances with @Binds
//    @Binds
//    abstract fun bindsUserRepository(sqlRepository: SQLRepository): UserRepository
}