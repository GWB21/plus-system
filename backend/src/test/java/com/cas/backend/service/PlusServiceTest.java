package com.cas.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlusServiceTest {

    @Mock
    private PlusService plusService; // PlusService의 Mock 객체 생성

    @Test
    void plus_proper() {
        int num1 = 5;
        int num2 = 3;

        when(plusService.plus(num1, num2)).thenReturn(8); // Mock 객체의 동작 설정

        Integer result = plusService.plus(num1, num2);

        assertEquals(8, result);
    }

//    @Test
//    void negative_plus() {
//        int nu
//    }

    // 다른 테스트 케이스들 추가
}