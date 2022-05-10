// Generated by Dagger (https://dagger.dev).
package com.example.coinpocket.di;

import android.app.Application;
import com.example.coinpocket.data.local.StockDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideStockDatabaseFactory implements Factory<StockDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideStockDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public StockDatabase get() {
    return provideStockDatabase(appProvider.get());
  }

  public static AppModule_ProvideStockDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideStockDatabaseFactory(appProvider);
  }

  public static StockDatabase provideStockDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStockDatabase(app));
  }
}
