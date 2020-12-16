package com.future.utils;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :ContentResultForm
 * 功能概要  :后台实体封装继承类
 * 做成日期  :2020-11-11  huangsl
 */
public class ContentResultForm<T> extends ResultForm {
    private T content;

    public ContentResultForm(boolean success) {
        super(success);
    }

    public ContentResultForm(boolean success, T content) {
        super(success);
        this.content = content;
    }

    public ContentResultForm(boolean success, T content, String message) {
        super(success, message);
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
