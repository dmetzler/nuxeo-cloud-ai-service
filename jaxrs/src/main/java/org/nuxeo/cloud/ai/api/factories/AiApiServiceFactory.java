package org.nuxeo.cloud.ai.api.factories;

import org.nuxeo.cloud.ai.api.AiApiService;
import org.nuxeo.cloud.ai.api.impl.AiApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-21T08:13:33.267Z")
public class AiApiServiceFactory {
    private final static AiApiService service = new AiApiServiceImpl();

    public static AiApiService getAiApi() {
        return service;
    }
}
