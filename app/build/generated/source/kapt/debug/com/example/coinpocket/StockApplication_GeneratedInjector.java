package com.example.coinpocket;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = StockApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface StockApplication_GeneratedInjector {
  void injectStockApplication(StockApplication stockApplication);
}
