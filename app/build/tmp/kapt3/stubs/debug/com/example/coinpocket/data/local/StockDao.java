package com.example.coinpocket.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/coinpocket/data/local/StockDao;", "", "clearCompanyListings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCompanyListings", "companyListingEntities", "", "Lcom/example/coinpocket/data/local/CompanyListingEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchCompanyListings", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface StockDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertCompanyListings(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.coinpocket.data.local.CompanyListingEntity> companyListingEntities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete From companylistingentity")
    public abstract java.lang.Object clearCompanyListings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "\n        Select *\n        From companylistingentity \n        where LOWER(name) LIKE \'%\' || LOWER(:query) || \'%\' OR UPPER(:query)== symbol\n\n            \n    ")
    public abstract java.lang.Object searchCompanyListings(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.coinpocket.data.local.CompanyListingEntity>> continuation);
}