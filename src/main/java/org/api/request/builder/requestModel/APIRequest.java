package org.api.request.builder.requestModel;

import lombok.Data;

import java.util.Map;

@Data
public class APIRequest {

    public String url;
    public String method;
    public Map<String, String> headers;
    public String body;

}
