package com.example.coinpocket.data;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/example/coinpocket/data/Coin;", "", "money", "", "percent", "", "dayofMonth", "Ljava/time/Month;", "(Ljava/lang/String;FLjava/time/Month;)V", "getDayofMonth", "()Ljava/time/Month;", "getMoney", "()Ljava/lang/String;", "getPercent", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Coin {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String money = null;
    private final float percent = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.time.Month dayofMonth = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.coinpocket.data.Coin copy(@org.jetbrains.annotations.NotNull()
    java.lang.String money, float percent, @org.jetbrains.annotations.NotNull()
    java.time.Month dayofMonth) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Coin(@org.jetbrains.annotations.NotNull()
    java.lang.String money, float percent, @org.jetbrains.annotations.NotNull()
    java.time.Month dayofMonth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMoney() {
        return null;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final float getPercent() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.Month component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.Month getDayofMonth() {
        return null;
    }
}