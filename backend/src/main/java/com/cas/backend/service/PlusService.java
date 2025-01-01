package com.cas.backend.service;

import com.cas.backend.model.Num;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlusService {
    public Integer plus(int num1, int num2) {
        return num1 + num2;
    }
}
