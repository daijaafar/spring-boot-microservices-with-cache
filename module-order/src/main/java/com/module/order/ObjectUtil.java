package com.module.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class ObjectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T readJsonToObject(String content, Class<T> valueType) {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public static <T> T convertJsonToObject(Object obj, Class<T> valueType) {
        return objectMapper.convertValue(obj, valueType);
    }

    public static String toJson(Object object) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return json;
    }

    public static <T> T jsonToObject(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public static <T> List<T> jsonToListObject(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, valueType));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
