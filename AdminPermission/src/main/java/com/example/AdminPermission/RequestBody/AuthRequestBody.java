package com.example.AdminPermission.RequestBody;

public class AuthRequestBody {


  public record LoginRequest(String email, String password) { };

}
