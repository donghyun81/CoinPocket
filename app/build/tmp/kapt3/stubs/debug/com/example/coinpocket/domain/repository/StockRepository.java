package com.example.coinpocket.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J3\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00030\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/coinpocket/domain/repository/StockRepository;", "", "getCompanyInfo", "Lcom/example/coinpocket/util/Resource;", "Lcom/example/coinpocket/presentation/company_info/CompanyInfo;", "symbol", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompanyListings", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/coinpocket/domain/model/CompanyListing;", "fetchFromRemote", "", "query", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntradayInfo", "Lcom/example/coinpocket/domain/model/IntradayInfo;", "app_debug"})
public abstract interface StockRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompanyListings(boolean fetchFromRemote, @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.coinpocket.util.Resource<java.util.List<com.example.coinpocket.domain.model.CompanyListing>>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIntradayInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.coinpocket.util.Resource<java.util.List<com.example.coinpocket.domain.model.IntradayInfo>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompanyInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.coinpocket.util.Resource<com.example.coinpocket.presentation.company_info.CompanyInfo>> continuation);
}