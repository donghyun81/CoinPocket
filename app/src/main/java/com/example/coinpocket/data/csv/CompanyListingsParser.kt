package com.example.coinpocket.data.csv

import com.example.coinpocket.domain.model.CompanyListing
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton
/*
Hilt는 Jetpack의 의존성을 주입해주는 라이브러리 중에 하나이다. Hilt는 모든 Android 클래스에 컨테이너를 제공하고 자동으로 생명주기를 관리한다.
 Hilt는 Dagger를 기반으로 빌드되어 Dagger가 제공하는 컴파일 시간 정확성, 런타임 퍼포먼스 및 Android Studio의 지원을 누릴 수 있다.
    @Singleton 어디서든 사용 할 수 있도록 Singleton 객체로 hilt에 선언
   @Inject 인스턴스 주입
 */
@Singleton
class CompanyListingsParser @Inject constructor() : CSVParser<CompanyListing> {
    override suspend fun parse(stream: InputStream): List<CompanyListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO){
            csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line->
                    val symbol = line.getOrNull(0)
                    val name =line.getOrNull(1)
                    val exchange = line.getOrNull(2)
                    CompanyListing(
                        name = name ?: return@mapNotNull null,
                        symbol = symbol ?: return@mapNotNull null,
                        exchange = exchange ?: return@mapNotNull null
                    )
                }
                .also {
                    csvReader.close()
                }
        }
    }
}