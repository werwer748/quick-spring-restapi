package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // restAPI 관련된 컨트롤러
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    // 'http://localhost:8080/member?empNo=21345&year=10' \
    @GetMapping("/member")
    public String getMember(
            @RequestParam(value = "empNo", required = false) String empNo,
            // required: 필수 체크, defaultValue: 기본값 지정
            @RequestParam("year") int year
    ) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
    }

    // 'http://localhost:8080/company/8888' \
    @GetMapping("/company/{id}")
    public String getCompany(
            @PathVariable("id") String id
//            @RequestParam("year") int year
    ) {
        log.info("id: {}", id);
        return "ok";
    }

    @PostMapping("/item")
    public String registerItem(@RequestBody String item) {
        log.info("item: {}", item);
        return "ok";
    }

    // json모양의 요청을 받아보기
    @PostMapping("/itemV2")
    public ResponseDto registerItemV2(@Valid @RequestBody ItemDto item) {
        log.info("item: {}", item);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("ok");
        return responseDto;
    }

    // Layer나누기
    @PostMapping("/itemV3")
    public ResponseDto registerItemV3(@Valid @RequestBody ItemDto item) {
//        QuickService quickService = new QuickService(); // 이렇게 쓰지 않고 바깥에서 주입받은걸 사용함
        boolean b = quickService.registerItem(item);

        if (b == true) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    @PostMapping("/itemV3-jpa")
    public ResponseDto registerItemV3Jpa(@Valid @RequestBody ItemDto item) {
        boolean b = quickService.registerItemJpa(item);

        if (b == true) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = quickService.getItemById(id);
        return res;
    }

    @GetMapping("/item-jpa")
    public ItemDto getItemJpa(@RequestParam("id") String id) {
        ItemDto res = quickService.getItemByIdJpa(id);
        return res;
    }
}
