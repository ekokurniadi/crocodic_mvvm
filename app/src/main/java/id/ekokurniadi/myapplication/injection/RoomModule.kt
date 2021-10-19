package id.ekokurniadi.myapplication.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import id.ekokurniadi.myapplication.data.room.AppDatabase
import javax.inject.Singleton

@Module
abstract class RoomModule {

    companion object{
        @JvmStatic
        @Singleton
        @Provides
        fun provideDatabase(context: Context) = AppDatabase.getDatabase(context)

        @JvmStatic
        @Singleton
        @Provides
        fun provideVisitDao(database: AppDatabase) = database.visitDao()
    }
}