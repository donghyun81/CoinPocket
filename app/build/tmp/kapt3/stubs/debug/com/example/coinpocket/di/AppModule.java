package com.example.coinpocket.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/coinpocket/di/AppModule;", "", "()V", "provideStockApi", "Lcom/example/coinpocket/data/remote/StockApi;", "provideStockDatabase", "Lcom/example/coinpocket/data/local/StockDatabase;", "app", "Landroid/app/Application;", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.coinpocket.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.coinpocket.data.remote.StockApi provideStockApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.coinpocket.data.local.StockDatabase provideStockDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
}