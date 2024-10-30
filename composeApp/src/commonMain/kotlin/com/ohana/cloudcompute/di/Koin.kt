package com.ohana.cloudcompute.di

import com.ohana.cloudcompute.data.BusApi
import com.ohana.cloudcompute.data.BusRepository
import com.ohana.cloudcompute.data.KtorCongestionApi // 혼잡도 API 클래스
import com.ohana.cloudcompute.data.CongestionApi // 혼잡도 API 인터페이스
import com.ohana.cloudcompute.data.CongestionRepository // 혼잡도 리포지토리 클래스
import com.ohana.cloudcompute.data.KtorBusApi
import com.ohana.cloudcompute.screens.BusViewModel
import com.ohana.cloudcompute.screens.SensorDataViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

// 데이터 관련 모듈 정의
val dataModule = module {
    single {
        // JSON 직렬화를 위한 Json 객체 설정
        val json = Json { ignoreUnknownKeys = true } // 알 수 없는 키를 무시하는 설정
        HttpClient {
            install(ContentNegotiation) {
                // API에서 JSON 형식으로 응답을 받을 수 있도록 설정
                json(json, contentType = ContentType.Any)
            }
        }
    }

    // Ktor를 사용하여 혼잡도 API 구현체 제공
    single<CongestionApi> { KtorCongestionApi(get()) }
    single<BusApi> {KtorBusApi(get())}

    // 혼잡도 데이터를 처리하는 리포지토리 제공
    single {
        CongestionRepository(get()).apply {
            initialize() // 리포지토리 초기화
        }
    }

    single {
        BusRepository(get()).apply {
            initialize()
        }
    }
}

// ViewModel 관련 모듈 정의
val viewModelModule = module {
    factory { SensorDataViewModel(get()) }
    factory { BusViewModel(get()) }
}

// Koin 초기화 함수
fun initKoin() {
    startKoin {
        modules(
            dataModule,      // 데이터 모듈 등록
            viewModelModule, // ViewModel 모듈 등록
        )
    }
}