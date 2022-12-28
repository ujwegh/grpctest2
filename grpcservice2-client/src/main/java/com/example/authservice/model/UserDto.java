package com.example.authservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID userUid;
    private String firstName;
    private String secondName;
    private String email;
    private String phone;
    private boolean emailVerified;
    private boolean phoneVerified;
    private boolean active;
}
