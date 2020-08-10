package com.imut.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/21 11:24
 */

public class UserNotExitException extends RuntimeException {

    public UserNotExitException() {
        super("用户不存在");
    }
}
