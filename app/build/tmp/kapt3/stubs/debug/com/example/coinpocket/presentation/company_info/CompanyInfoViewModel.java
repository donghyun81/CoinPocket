package com.example.coinpocket.presentation.company_info;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/example/coinpocket/presentation/company_info/CompanyInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "repository", "Lcom/example/coinpocket/domain/repository/StockRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/example/coinpocket/domain/repository/StockRepository;)V", "<set-?>", "Lcom/example/coinpocket/presentation/company_info/CompanyInfoState;", "state", "getState", "()Lcom/example/coinpocket/presentation/company_info/CompanyInfoState;", "setState", "(Lcom/example/coinpocket/presentation/company_info/CompanyInfoState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "app_debug"})
public final class CompanyInfoViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    private final com.example.coinpocket.domain.repository.StockRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState state$delegate = null;
    
    @javax.inject.Inject()
    public CompanyInfoViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.example.coinpocket.domain.repository.StockRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.coinpocket.presentation.company_info.CompanyInfoState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    com.example.coinpocket.presentation.company_info.CompanyInfoState p0) {
    }
}