/**   
 *
 */
package com.example.springbootdemo.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author haihuab
 * @date 2018年6月9日 上午10:37:19
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper om ;
    static{
        om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType){
        return om.convertValue(fromValue, toValueType) ;
    }

    public static String objectToJson(Object jsonObj) {
        if (jsonObj == null) {
            return null;
        }
        //om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonStr = null;

        try {
            jsonStr = om.writeValueAsString(jsonObj);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return jsonStr;

    }

    public static <T> T jsonToObject(String jsonStr, Class<T> jsonType) {
        if (jsonStr == null) {
            return null;
        }

        T jsonObj = null;

        try {
            jsonObj = om.readValue(jsonStr, jsonType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return jsonObj;

    }

    public static <T> T jsonToObject(File inFile, Class<T> jsonType) {
        if (inFile == null) {
            return null;
        }


        T jsonObj = null;

        try {
            jsonObj = om.readValue(inFile, jsonType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return jsonObj;

    }

    public static <T> T jsonToObject(InputStream inputStream, Class<T> jsonType) {
        if (inputStream == null) {
            return null;
        }


        T jsonObj = null;

        try {
            jsonObj = om.readValue(inputStream, jsonType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return jsonObj;

    }

}
