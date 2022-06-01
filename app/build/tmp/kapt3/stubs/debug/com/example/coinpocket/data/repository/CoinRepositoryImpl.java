package com.example.coinpocket.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/coinpocket/data/repository/CoinRepositoryImpl;", "Lcom/example/coinpocket/domain/repository/CoinRepository;", "dao", "Lcom/example/coinpocket/data/local/CoinDao;", "(Lcom/example/coinpocket/data/local/CoinDao;)V", "getCoin", "Lcom/example/coinpocket/data/local/CoinEntity;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCoin", "", "coinEntity", "(Lcom/example/coinpocket/data/local/CoinEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CoinRepositoryImpl implements com.example.coinpocket.domain.repository.CoinRepository {
    private final com.example.coinpocket.data.local.CoinDao dao = null;
    
    public CoinRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.data.local.CoinDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertCoin(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.data.local.CoinEntity coinEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getCoin(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.coinpocket.data.local.CoinEntity> continuation) {
        return null;
    }
}