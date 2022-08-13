// Generated by Dagger (https://dagger.dev).
package com.example.coinpocket.di;

import com.example.coinpocket.data.remote.StockApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideStockApiFactory implements Factory<StockApi> {
  @Override
  public StockApi get() {
    return provideStockApi();
  }

  public static AppModule_ProvideStockApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StockApi provideStockApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStockApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideStockApiFactory INSTANCE = new AppModule_ProvideStockApiFactory();
  }
}