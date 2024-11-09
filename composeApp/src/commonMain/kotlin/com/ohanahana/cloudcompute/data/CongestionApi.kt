package com.ohanahana.cloudcompute.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.CancellationException

// 혼잡도 API 인터페이스 정의
// 이 인터페이스는 혼잡도 데이터를 가져오는 메소드를 포함하고 있음
interface CongestionApi {
    // 비동기 메소드로 혼잡도 데이터를 가져오는 함수
    // 반환 타입은 CongestionObject의 리스트
    suspend fun getData(): CongestionObject
}

// Ktor를 사용하여 HTTP 요청을 처리하는 클래스
// CongestionApi를 구현함
class KtorCongestionApi(private val client: HttpClient) : CongestionApi {
    companion object {
        // API URL 상수 정의
        private const val API_URL = "http://ohhanahana.kro.kr:8080/congestion/random" // 혼잡도 조회 API의 URL
    }

    // getData 메소드 구현
    // API를 호출하여 혼잡도 데이터를 가져옴
    override suspend fun getData(): CongestionObject {
        return try {
            // HTTP GET 요청을 보내고 응답 본문을 CongestionObject 리스트로 변환
            client.get(API_URL).body()
        } catch (e: Exception) {
            // 요청 중 예외가 발생했을 경우 처리
            if (e is CancellationException) throw e // 요청이 취소된 경우 다시 던짐
            e.printStackTrace() // 예외 스택 트레이스를 출력하여 디버깅에 도움을 줌

            // 예외가 발생한 경우 빈 리스트 반환
            CongestionObject("", "", "", 0, "")
        }
    }
}
