package com.example.coinpocket.data.csv;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/example/coinpocket/data/csv/CSVParser;", "T", "", "parse", "", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CSVParser<T extends java.lang.Object> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object parse(@org.jetbrains.annotations.NotNull()
    java.io.InputStream stream, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation);
}