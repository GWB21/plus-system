package com.cas.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 서비스 레이어
 * @author baegeun-u
 * */
@Service
public class PlusService {
    /**
     * 플러스 함수
     * @return Integer*/
    public Integer plus(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
