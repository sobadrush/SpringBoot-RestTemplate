package com.nanshan.springbootresttemplate.utils.restful;

public enum ApiUriConfig {

    WEATHER_API {
        @Override
        public String getUriInfo() {
            return "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001";
        }
    },
    JSON_PLACEHOLDER {
        @Override
        public String getUriInfo() {
            return "https://jsonplaceholder.org";
        }
    };

    /**
     * 定義 enum 中的抽象方法
     */
    public abstract String getUriInfo();
}
