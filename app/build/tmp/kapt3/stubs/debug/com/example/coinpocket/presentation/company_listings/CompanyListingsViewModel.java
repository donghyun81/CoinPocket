package com.example.coinpocket.presentation.company_listings;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/example/coinpocket/presentation/company_listings/CompanyListingsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/coinpocket/domain/repository/StockRepository;", "(Lcom/example/coinpocket/domain/repository/StockRepository;)V", "searchJob", "Lkotlinx/coroutines/Job;", "<set-?>", "Lcom/example/coinpocket/presentation/company_listings/CompanyListingsState;", "state", "getState", "()Lcom/example/coinpocket/presentation/company_listings/CompanyListingsState;", "setState", "(Lcom/example/coinpocket/presentation/company_listings/CompanyListingsState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "getCompanyListings", "", "query", "", "fetchFromRemote", "", "onEvent", "event", "Lcom/example/coinpocket/presentation/company_listings/CompanyListingsEvent;", "app_debug"})
public final class CompanyListingsViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.coinpocket.domain.repository.StockRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState state$delegate = null;
    private kotlinx.coroutines.Job searchJob;
    
    @javax.inject.Inject()
    public CompanyListingsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.domain.repository.StockRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.coinpocket.presentation.company_listings.CompanyListingsState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.presentation.company_listings.CompanyListingsState p0) {
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.presentation.company_listings.CompanyListingsEvent event) {
    }
    
    private final void getCompanyListings(java.lang.String query, boolean fetchFromRemote) {
    }
}