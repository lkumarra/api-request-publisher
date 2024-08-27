package org.api.request.builder;

import org.api.request.builder.publisher.Publisher;
import org.api.request.builder.requestBuilder.ProductAPIRequestBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
       while (true){
            ProductAPIRequestBuilder requestBuilder = new ProductAPIRequestBuilder();
            Publisher publisher = new Publisher();
            publisher.publishMessage(requestBuilder.buildProductAPIGetRequest());
            publisher.publishMessage(requestBuilder.buildProductAPIGetRequestWithId());
            Thread.sleep(100);
        }
    }
}
