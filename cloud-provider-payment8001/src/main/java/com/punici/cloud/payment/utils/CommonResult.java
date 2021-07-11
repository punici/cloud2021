package com.punici.cloud.payment.utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommonResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Integer code;
    
    private String desc;
    
    @JsonIgnore
    private String requestUri;
    
    protected T result;
    
    public CommonResult()
    {
        this.code = ResponseCode.SUCCESS.getCode();
        this.desc = ResponseCode.SUCCESS.getDesc();
    }
    
    public CommonResult(ResponseCode resCode)
    {
        this.code = resCode.getCode();
        this.desc = resCode.getDesc();
    }
    
    public CommonResult(AbstractBusinessException exception)
    {
        this.code = exception.getResponseCode();
        this.desc = exception.getMessage();
    }
    
    public CommonResult(Integer code, String msg)
    {
        this.code = ResponseCode.getByCode(code).getCode();
        this.desc = msg;
    }
    
    public CommonResult(T result)
    {
        this.result = result;
    }
}