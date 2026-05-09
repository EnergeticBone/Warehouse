package com.bone.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZE_ERROR(500, "UNCATEGORIZE_ERROR"),
    WRONG_ENUMKEY(500, "WRONG_ENUMKEY"),
    USER_EXISTED(401, "User Existed"),
    USER_NOT_FOUND(404, "User Not Found"),
    USER_NOTFOUND(402, "User not found"),
    USERNAME_INVALID(403, "Username is invalid"),
    BLANK_USERNAME(400, "Blank Username"),
    PASSWORD_TOO_SHORT(404, "Password must be at least 8 characters long"),
    PASSWORD_TOO_LONG(404, "Password must not be exceed 20 characters long"),
    BLANK_PASSWORD(400, "Password can not be empty"),
    WRONG_CFPASSWORD(400, "Confirm password is invalid"),
    BLANK_FIRSTNAME(400, "First Name can not be empty"),
    BLANK_LASTNAME(400, "Last Name can not be empty"),
    ;

    private int code;
    private String message;
}
