package com.andromeda.casediary.models.responsedto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class GenericResponseMetaData {
    private HttpStatus httpstatus;
    private String customErrorCode;
    private String message;
    private String errorStackTrace;
}
