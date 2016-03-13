package org.yukatan.rapid.common.scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus Barquín on 5/03/16.
 */
public class RapidScope extends HashMap<String,Object> {


    public static RapidScope create(){

        RapidScope scope = new RapidScope();
        scope.put(ScopeKeys.REQUEST_SCOPE,new HashMap<>());
        scope.put(ScopeKeys.RESPONSE_SCOPE,new HashMap<>());
        scope.put(ScopeKeys.ERROR_SCOPE,new HashMap<>());
        return scope;
    }

    public HashMap<String,Object> getRequestScope(){

        return (HashMap<String, Object>) get(ScopeKeys.REQUEST_SCOPE);
    }

    public HashMap<String,Object> getResponseScope(){

        return (HashMap<String, Object>) get(ScopeKeys.RESPONSE_SCOPE);
    }

    public HashMap<String,Object> getErrorScope(){

        return (HashMap<String, Object>) get(ScopeKeys.ERROR_SCOPE);
    }


    public Object getPath(String path){

        String[] scopes = path.split("\\.");
        return navigatePath(this,scopes,0);
    }

    private Object navigatePath(Map<String,Object> scope, String[]nodes, int index){

        if(index < nodes.length -1){
            Map<String,Object> innerScope = (Map<String,Object>) scope.get(nodes[index]);
            index++;
            return navigatePath(innerScope,nodes,index);
        }
        return scope.get(nodes[index]);
    }

    private boolean findKey(Map<String,Object> scope, String[]nodes, int index){

        if(index < nodes.length -1){
            Map<String,Object> innerScope = (Map<String,Object>) scope.get(nodes[index]);
            index++;
            return findKey(innerScope,nodes,index);
        }
        return scope.containsKey(nodes[index]);
    }

    public boolean containsKey(String key) {

        String[] scopes = key.split("\\.");
        return findKey(this,scopes,0);
    }
}
