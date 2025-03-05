package com.example.AdminPermission.Utils;

import java.time.LocalDate;

public class ApiResponse<T>{

    private int status;
    private T data;
    private String timestamp = LocalDate.now().toString();
    private String path;      // API endpoint path (e.g., "/users/123")
    private String message;

    // Constructor
    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message =  message;
        this.data = data;
        this.path = path;
    }
    public ApiResponse() {
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
