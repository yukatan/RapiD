package org.yukatan.rapid.common.descriptor;

import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
@SuppressWarnings("unchecked")
public class RapidDescriptor extends LinkedHashMap<String,Object> {

    public LinkedHashMap<String, Object> getPhaseDescriptor(String key){

        return (LinkedHashMap<String, Object>) get(key);
    }

    public LinkedHashMap<String,Object> getValidation(){

        return (LinkedHashMap<String, Object>) get("validation");
    }

    public String getString(String key){

        return (String) get(key);
    }
}
