package com.Learning2026.Exception;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Response {

    private String message;
    private String error;
    private LocalDateTime timeStamp;
    private int status;
    private String path;
}
