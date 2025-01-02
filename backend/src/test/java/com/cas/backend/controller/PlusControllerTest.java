package com.cas.backend.controller;

import com.cas.backend.model.AddRequest;
import com.cas.backend.service.PlusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


//Mock을 쓰는 이유? 실제 객체 생성하지 않고, 가짜 객체를 만들어내기 위함임.
@ExtendWith(MockitoExtension.class) // JUnit 5와 Mockito 통합
public class PlusControllerTest {

    @Mock // PlusService의 Mock 객체 생성
    private PlusService plusService;

    @InjectMocks // PlusController 객체 생성 및 Mock 객체 주입
    private PlusController plusController;

    @Test
    void proper_add_request() {
        // Given (준비): Mock 객체의 동작 설정
        AddRequest request = new AddRequest(5, 3);
        when(plusService.plus(5, 3)).thenReturn(8); // Mock 설정: plusService.plus 호출 시 8 반환

        // When (실행): 테스트 대상 메소드 호출
        ResponseEntity<Integer> response = plusController.add(request);

        // Then (검증): 결과 확인 및 Mock 객체 상호 작용 검증
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(8, response.getBody());
        verify(plusService).plus(5, 3); // Mock 메서드 호출 검증
    }
}
