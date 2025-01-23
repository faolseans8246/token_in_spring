package org.example.create_token.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success = false;
    private Object data;

    public ApiResponse(String message) {
        this.message = message;
        this.success = true;
    }

    public ApiResponse(Object data) {
        this.data = data;
        this.success = true;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(Object data, boolean success) {
        this.data = data;
        this.success = success;
    }
}
