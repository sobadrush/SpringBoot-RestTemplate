package com.nanshan.springbootresttemplate.utils.restful;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiConfig {

    AUTH_CODE("API授權碼", "CWB-6E8AA8B5-7439-4594-87ED-D0F64204DFCA");

    private String name;
    private String val;

}
