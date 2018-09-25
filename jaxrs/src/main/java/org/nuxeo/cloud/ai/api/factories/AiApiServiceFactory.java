package org.nuxeo.cloud.ai.api.factories;

import org.nuxeo.cloud.ai.api.AiApiService;
import org.nuxeo.cloud.ai.api.impl.AiApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-25T15:38:17.391Z")
public class AiApiServiceFactory {
    private final static AiApiService service = new AiApiServiceImpl();

    public static AiApiService getAiApi() {
        return service;
    }
}
