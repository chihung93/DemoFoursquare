package com.henry.foursquare.di.modules;

import android.content.Context;

import com.henry.foursquare.data.sources.SearchApi;
import com.henry.foursquare.global.Constant;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class RestfulModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder,String endPoint) {
        return builder.baseUrl(endPoint)
                .build();
    }

    @Provides
    @Singleton
    Retrofit.Builder provideBuilderCommon(OkHttpClient client){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message));
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    String provideEndPointApp() {
        return Constant.END_POINT;
    }

    @Provides
    @Singleton
    SearchApi provideSearchApiApi(Retrofit retrofit) {
        return retrofit.create(SearchApi.class);
    }
}
