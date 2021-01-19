package com.sunny.controller;

import com.sunny.dto.UserDTO;
import com.sunny.entity.ResponseEntity;
import com.sunny.exception.ParamErrorException;
import com.sunny.service.RegisterService;
import com.sunny.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        // 参数校验
        userDTO.registerCheckParam();

        try {
            // 执行注册方法
            registerService.register(userDTO);
            UserVO userVO = userDTO.getEntity().getVO();
            return ResponseEntity.normalReturn("注册成功", 200, userVO);
        } catch (Exception e) {
            return ResponseEntity.normalReturn(e.getMessage(), 101, null);
        }
    }

//    @GetMapping("test")
//    public ResponseEntity test() {
//        // 打印线程名
//        System.out.println(Thread.currentThread().getName());
//        // 模拟服务器响应慢，假如要响应10秒
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.normalReturn("", 200, "");
//    }
//
//    @GetMapping("test2")
//    public ResponseEntity test2() {
//        // 打印线程名
//        System.out.println(Thread.currentThread().getName());
//        // 模拟服务器响应慢，假如要响应5秒
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.normalReturn("", 200, "");
//    }
//
//    @GetMapping("test3")
//    public ResponseEntity test3() {
//        // 如果没有异常处理，这里代码在运行时会直接报错抛出，导致程序异常
//        try {
//            throw new ParamErrorException();
//        } catch (Exception e) {
//            throw new ParamErrorException();
//        }
//    }
}
