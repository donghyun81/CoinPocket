package com.example.coinpocket.presentation.coin_main;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/coinpocket/presentation/coin_main/CoinMainViewModel;", "Landroidx/lifecycle/ViewModel;", "useCases", "Lcom/example/coinpocket/domain/use_case/CoinUseCases;", "(Lcom/example/coinpocket/domain/use_case/CoinUseCases;)V", "Coins", "Lcom/example/coinpocket/domain/use_case/GetCoin;", "getCoins", "()Lcom/example/coinpocket/domain/use_case/GetCoin;", "onEvent", "", "event", "Lcom/example/coinpocket/presentation/coin_main/CoinMainEvent;", "app_debug"})
public final class CoinMainViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.coinpocket.domain.use_case.CoinUseCases useCases = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.coinpocket.domain.use_case.GetCoin Coins = null;
    
    @javax.inject.Inject()
    public CoinMainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.domain.use_case.CoinUseCases useCases) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.coinpocket.domain.use_case.GetCoin getCoins() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.presentation.coin_main.CoinMainEvent event) {
    }
}