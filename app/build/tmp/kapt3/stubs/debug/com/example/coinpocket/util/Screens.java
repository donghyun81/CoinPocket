package com.example.coinpocket.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/coinpocket/util/Screens;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Home", "Profile", "SearchStock", "Lcom/example/coinpocket/util/Screens$Home;", "Lcom/example/coinpocket/util/Screens$SearchStock;", "Lcom/example/coinpocket/util/Screens$Profile;", "app_debug"})
public abstract class Screens {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screens(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/coinpocket/util/Screens$Home;", "Lcom/example/coinpocket/util/Screens;", "()V", "app_debug"})
    public static final class Home extends com.example.coinpocket.util.Screens {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.coinpocket.util.Screens.Home INSTANCE = null;
        
        private Home() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/coinpocket/util/Screens$SearchStock;", "Lcom/example/coinpocket/util/Screens;", "()V", "app_debug"})
    public static final class SearchStock extends com.example.coinpocket.util.Screens {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.coinpocket.util.Screens.SearchStock INSTANCE = null;
        
        private SearchStock() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/coinpocket/util/Screens$Profile;", "Lcom/example/coinpocket/util/Screens;", "()V", "app_debug"})
    public static final class Profile extends com.example.coinpocket.util.Screens {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.coinpocket.util.Screens.Profile INSTANCE = null;
        
        private Profile() {
            super(null);
        }
    }
}