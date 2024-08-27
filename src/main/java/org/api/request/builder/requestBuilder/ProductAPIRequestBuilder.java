package org.api.request.builder.requestBuilder;

import org.api.request.builder.helpers.PropertyReaderHelper;
import org.api.request.builder.requestModel.APIRequest;

import java.util.HashMap;
import java.util.Map;

public class ProductAPIRequestBuilder {

    private final PropertyReaderHelper propertyReaderHelper;

    public ProductAPIRequestBuilder() {
        propertyReaderHelper = new PropertyReaderHelper(System.getProperty("user.dir") + "/src/main/resources/app-config.properties");
    }

    public APIRequest buildProductAPIGetRequest() {
        APIRequest request = new APIRequest();
        request.setUrl(propertyReaderHelper.getProperty("baseUrl") + "/products");
        request.setMethod("GET");
        Map<String, String> headers = new HashMap<>();
        headers.put("contentType", "application/json");
        request.setHeaders(headers);
        return request;
    }

    public APIRequest buildProductAPIGetRequestWithId() {
        APIRequest request = new APIRequest();
        request.setUrl(propertyReaderHelper.getProperty("baseUrl") + "/products/43900");
        request.setMethod("GET");
        Map<String, String> headers = new HashMap<>();
        headers.put("contentType", "application/json");
        request.setHeaders(headers);
        return request;
    }
}
