// Generated by Dagger (https://dagger.dev).
package com.example.coinpocket.di;

import com.example.coinpocket.domain.repository.CoinRepository;
import com.example.coinpocket.domain.use_case.CoinUseCases;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideCoinUseCasesFactory implements Factory<CoinUseCases> {
  private final Provider<CoinRepository> repositoryProvider;

  public AppModule_ProvideCoinUseCasesFactory(Provider<CoinRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CoinUseCases get() {
    return provideCoinUseCases(repositoryProvider.get());
  }

  public static AppModule_ProvideCoinUseCasesFactory create(
      Provider<CoinRepository> repositoryProvider) {
    return new AppModule_ProvideCoinUseCasesFactory(repositoryProvider);
  }

  public static CoinUseCases provideCoinUseCases(CoinRepository repository) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCoinUseCases(repository));
  }
}
