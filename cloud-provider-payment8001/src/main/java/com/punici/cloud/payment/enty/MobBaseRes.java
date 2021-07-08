package com.punici.cloud.payment.enty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class MobBaseRes implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Integer code;
    
    private String desc;
    
    @JsonIgnore
    private String requestUri;
    
    public MobBaseRes()
    {
        this.code = ResponseCode.SUCCESS.getCode();
        this.desc = ResponseCode.SUCCESS.getDesc();
    }
    
    public MobBaseRes(ResponseCode resCode)
    {
        this.code = resCode.getCode();
        this.desc = resCode.getDesc();
    }
    
    public MobBaseRes(AbstractBusinessException exception)
    {
        this.code = exception.getResponseCode();
        this.desc = exception.getMessage();
    }
    
    public MobBaseRes(Integer code, String msg)
    {
        this.code = ResponseCode.getByCode(code).getCode();
        this.desc = msg;
    }
    
    public Integer getCode()
    {
        return this.code;
    }
    
    public void setCode(Integer code)
    {
        this.code = code;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    public String getRequestUri()
    {
        return this.requestUri;
    }
    
    public void setRequestUri(String requestUri)
    {
        this.requestUri = requestUri;
    }
}