package com.cas.backend.exceptionHandle;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        LocalDateTime timestamp, // 발생 시간
        int status,             // HTTP 상태 코드
        String error,            // 오류 이름/타입
        String message,          // 오류 메시지
        String path,             // 요청 경로
        Map<String, String> details // 상세 정보 (예: 유효성 검사 오류)
) {
    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message, path, null);
    }
    public static ErrorResponse of(int status, String error, String message, String path, Map<String, String> details) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message, path, details);
    }
}