package com.example.springjwt.model.response;

import com.example.springjwt.utility.Constants;
import com.example.springjwt.utility.Utilities;

import java.util.Collections;
import java.util.List;

public class ApiResponse {
    private List<Object> data= Collections.emptyList();
    private String message;
    private String status;
    private int statusCode;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }



    public ApiResponse(List<Object> data, String message, String status, int statusCode) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }
   public static ApiResponse failApiResponse(String message,int statusCode){
        return new ApiResponse(Collections.emptyList(), message, Constants.MSG_STATUS_FAIL, statusCode);
   }
    public static ApiResponse successApiResponse(List<Object> data, String message, int statusCode){
        return new ApiResponse(data, message, Constants.MSG_STATUS_SUC, statusCode);
    }

}
