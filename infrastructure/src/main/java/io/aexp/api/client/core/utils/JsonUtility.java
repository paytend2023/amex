/*
 * Copyright (c) 2017 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.aexp.api.client.core.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.paytend.amex.exception.JsonException;

import java.util.Map;

/**
 * @author gudongyang
 */
public class JsonUtility {
    private final ObjectMapper mapper;

    private final XmlMapper xmlMapper;
    private final static JsonUtility INSTANCE = new JsonUtility();

    private JsonUtility() {
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

    }

    public static JsonUtility getInstance() {
        return INSTANCE;
    }

    public <T> T getObject(String jsonString, Class<T> objectClass) {
        try {
            return mapper.readValue(jsonString, objectClass);
        } catch (Exception e) {
            throw new JsonException("Exception mapping string to class, caused by " + e.getMessage(), e);
        }
    }

    public <T> T getObject(String jsonString, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(jsonString, typeReference);
        } catch (Exception e) {
            throw new JsonException("Exception mapping string to class, caused by " + e.getMessage(), e);
        }
    }

    public String getString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonException("Exception writing object as string, caused by " + e.getMessage(), e);
        }
    }

    public String getXml(Object obj) {
        try {
            return xmlMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonException("Exception writing object as string, caused by " + e.getMessage(), e);
        }
    }

    public <T> T xml2Obj(String xml, Class<T> objectClass) {
        try {
            return xmlMapper.readValue(xml, objectClass);
        } catch (JsonProcessingException e) {
            throw new JsonException("Exception writing object as string, caused by " + e.getMessage(), e);
        }
    }




    public String prettyString(String jsonString) {
        try {
            return getString(getObject(jsonString, Map.class));
        } catch (Exception e) {
            //on error, just return the string passed in
            return jsonString;
        }
    }
}
