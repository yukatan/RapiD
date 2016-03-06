package org.yukatan.rapid.core.descriptor;

import java.util.LinkedHashMap;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class RapidDescriptor extends LinkedHashMap<String,Object> {

    public RapidDescriptor getDescriptor(String key){

        return (RapidDescriptor) get(key);
    }

    public LinkedHashMap<String,Object> getValidation(){

        return (LinkedHashMap<String, Object>) get("validation");
    }

    public String getString(String key){

        return (String) get(key);
    }
}
