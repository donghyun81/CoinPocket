// Generated by Dagger (https://dagger.dev).
package com.example.coinpocket.presentation.company_listings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CompanyListingsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static CompanyListingsViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(CompanyListingsViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final CompanyListingsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CompanyListingsViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}