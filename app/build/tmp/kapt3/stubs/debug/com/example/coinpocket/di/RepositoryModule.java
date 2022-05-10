package com.example.coinpocket.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/coinpocket/di/RepositoryModule;", "", "()V", "bindCompanyListingParser", "Lcom/example/coinpocket/data/csv/CSVParser;", "Lcom/example/coinpocket/domain/model/CompanyListing;", "companyListingsParser", "Lcom/example/coinpocket/data/csv/CompanyListingsParser;", "bindIntradayInfoParser", "Lcom/example/coinpocket/domain/model/IntradayInfo;", "intradayInfoParser", "Lcom/example/coinpocket/data/csv/IntradayInfoParser;", "bindStockRepository", "Lcom/example/coinpocket/domain/repository/StockRepository;", "stockRepositoryImpl", "Lcom/example/coinpocket/data/repository/StockRepositoryImpl;", "app_debug"})
@dagger.Module()
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.example.coinpocket.data.csv.CSVParser<com.example.coinpocket.domain.model.CompanyListing> bindCompanyListingParser(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.data.csv.CompanyListingsParser companyListingsParser);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.example.coinpocket.data.csv.CSVParser<com.example.coinpocket.domain.model.IntradayInfo> bindIntradayInfoParser(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.data.csv.IntradayInfoParser intradayInfoParser);
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Binds()
    public abstract com.example.coinpocket.domain.repository.StockRepository bindStockRepository(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.data.repository.StockRepositoryImpl stockRepositoryImpl);
}