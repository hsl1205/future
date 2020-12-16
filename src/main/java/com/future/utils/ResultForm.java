package com.future.utils;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :ResultForm
 * 功能概要  :后台返回封装类
 * 做成日期  :2020-11-11  huangsl
 */
public class ResultForm {
    protected boolean success;
    protected String message;

    public ResultForm(boolean success) {
        this.success = success;
        this.message = "";
    }

    public ResultForm(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
