package mx.mauriciogs.storage.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesDispatchersModule {

    @Provides
    fun provideCoroutinesDispatchers() = CoroutinesDispatchers()
}