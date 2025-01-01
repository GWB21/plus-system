package com.cas.backend.controller;

import com.cas.backend.model.AddRequest;
import com.cas.backend.service.PlusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // 생성자 주입을 위한 Lombok 어노테이션
@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class PlusController {

    private final PlusService plusService; // final 키워드 유지, 직접 객체 생성 X

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody AddRequest request) {
        int result = plusService.plus(request.num1(), request.num2());
        return ResponseEntity.ok(result); // 성공적인 응답 반환
    }
}