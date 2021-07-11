package com.punici.cloud.payment.utils;

public abstract class AbstractBusinessException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    private Integer responseCode = null;
    
    public AbstractBusinessException()
    {
    }
    
    public AbstractBusinessException(String msg)
    {
        super(msg);
    }
    
    public AbstractBusinessException(String msg, Integer responseCode)
    {
        super(msg);
        this.responseCode = responseCode;
    }
    
    public AbstractBusinessException(String msgTemplete, Object[] objs)
    {
        super(String.format(msgTemplete, objs));
    }
    
    public AbstractBusinessException(Exception e)
    {
        super(e);
    }
    
    public AbstractBusinessException(String msg, Exception e)
    {
        super(msg, e);
    }
    
    public void setResponseCode(Integer responseCode)
    {
        this.responseCode = responseCode;
    }
    
    public int getResponseCode()
    {
        if(null == this.responseCode)
        {
            this.responseCode = ResponseCode.BUSINESS_EXCEPTION.getCode();
        }
        
        return this.responseCode;
    }
}