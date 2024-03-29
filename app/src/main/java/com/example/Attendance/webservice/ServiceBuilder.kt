package com.example.Attendance.webservice
 import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    class ServiceBuilder {

        companion object {
            private val retrofit = Retrofit.Builder()
                    //this is for Nox player Emulator
                .baseUrl("http://172.17.100.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            fun <S> buildService(serviceType: Class<S>): S {
                return retrofit.create(serviceType)
            }
        }
    }
