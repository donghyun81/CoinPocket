package com.example.coinpocket.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J%\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/coinpocket/data/remote/StockApi;", "", "getCompanyInfo", "Lcom/example/coinpocket/data/remote/dto/CompanyInfoDto;", "symbol", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntradayInfo", "Lokhttp3/ResponseBody;", "getListings", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface StockApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.coinpocket.data.remote.StockApi.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "C1TG4JH2C8YA8DA6";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://alphavantage.co";
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "query?function=LISTING_STATUS")
    public abstract java.lang.Object getListings(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apikey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "query?function=TIME_SERIES_INTRADAY&interval=60min&datatype=csv")
    public abstract java.lang.Object getIntradayInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apikey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "query?function=OVERVIEW")
    public abstract java.lang.Object getCompanyInfo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apikey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.coinpocket.data.remote.dto.CompanyInfoDto> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/coinpocket/data/remote/StockApi$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String API_KEY = "C1TG4JH2C8YA8DA6";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://alphavantage.co";
        
        private Companion() {
            super();
        }
    }
}