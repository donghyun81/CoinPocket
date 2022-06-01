// Generated by Dagger (https://dagger.dev).
package com.example.coinpocket.presentation.coin_main;

import com.example.coinpocket.domain.use_case.CoinUseCases;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CoinMainViewModel_Factory implements Factory<CoinMainViewModel> {
  private final Provider<CoinUseCases> useCasesProvider;

  public CoinMainViewModel_Factory(Provider<CoinUseCases> useCasesProvider) {
    this.useCasesProvider = useCasesProvider;
  }

  @Override
  public CoinMainViewModel get() {
    return newInstance(useCasesProvider.get());
  }

  public static CoinMainViewModel_Factory create(Provider<CoinUseCases> useCasesProvider) {
    return new CoinMainViewModel_Factory(useCasesProvider);
  }

  public static CoinMainViewModel newInstance(CoinUseCases useCases) {
    return new CoinMainViewModel(useCases);
  }
}
