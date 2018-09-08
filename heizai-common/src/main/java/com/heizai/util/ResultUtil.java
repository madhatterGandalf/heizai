package com.heizai.util;

/**
 * 结果返回
 */
public class ResultUtil {
    private boolean status;
    private String message;
    private Object resultData;

    public ResultUtil(){}

    public ResultUtil(boolean status, String message, Object resultData) {
        this.status = status;
        this.message = message;
        this.resultData = resultData;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        return "ResultUtil{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", resultData=" + resultData +
                '}';
    }
}
