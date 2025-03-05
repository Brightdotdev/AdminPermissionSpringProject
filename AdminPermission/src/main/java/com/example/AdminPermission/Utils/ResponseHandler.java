package com.example.AdminPermission.Utils;
import org.springframework.http.HttpStatus;
public class ResponseHandler{
    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Success",
                data
        );
    }



    // Generic method to create error responses
    public static <T> ApiResponse<T> error(int status, String message, String path) {
        return new ApiResponse<>(
                status,
                message,
                null
        );
    }
}
