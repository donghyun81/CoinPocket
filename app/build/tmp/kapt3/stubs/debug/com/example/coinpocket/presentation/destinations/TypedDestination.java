package com.example.coinpocket.presentation.destinations;

import java.lang.System;

/**
 * TypedDestination is a sealed version of [DestinationSpec]
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002\u0082\u0001\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/coinpocket/presentation/destinations/TypedDestination;", "T", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "Lcom/example/coinpocket/presentation/destinations/CompanyinfoScreenDestination;", "Lcom/example/coinpocket/presentation/destinations/DirectionDestination;", "app_debug"})
public abstract interface TypedDestination<T extends java.lang.Object> extends com.ramcosta.composedestinations.spec.DestinationSpec<T> {
    
    /**
     * TypedDestination is a sealed version of [DestinationSpec]
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends java.lang.Object>java.util.List<androidx.navigation.NamedNavArgument> getArguments(@org.jetbrains.annotations.NotNull()
        com.example.coinpocket.presentation.destinations.TypedDestination<T> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends java.lang.Object>java.util.List<androidx.navigation.NavDeepLink> getDeepLinks(@org.jetbrains.annotations.NotNull()
        com.example.coinpocket.presentation.destinations.TypedDestination<T> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends java.lang.Object>com.ramcosta.composedestinations.spec.DestinationStyle getStyle(@org.jetbrains.annotations.NotNull()
        com.example.coinpocket.presentation.destinations.TypedDestination<T> $this) {
            return null;
        }
    }
}