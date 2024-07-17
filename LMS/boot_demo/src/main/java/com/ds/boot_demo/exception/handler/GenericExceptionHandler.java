package com.ds.boot_demo.exception.handler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import com.ds.boot_demo.exception.*;
import com.ds.boot_demo.response.*;

@RestControllerAdvice
public class GenericExceptionHandler {
   @ExceptionHandler
   public ResponseEntity<CommonResponse<Integer>> empoyeeExceptionHandler(EmployeeException e){
   return ResponseEntity.ok(CommonResponse.<Integer>builder().isError(true).data(null).message(e.getMessage()).build());
   }
}
