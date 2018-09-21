package org.nuxeo.cloud.ai.api.factories;

import org.jdbi.v3.core.Jdbi;
import org.nuxeo.cloud.ai.api.AiApiService;
import org.nuxeo.cloud.ai.api.impl.AiApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-21T04:16:44.923Z")
public class AiApiServiceFactory {


    private static AiApiService service;
    private static Jdbi jdbi;


    public static void registerJdbi(Jdbi jdbi) {
        AiApiServiceFactory.jdbi = jdbi;
    }
    public static AiApiService getAiApi() {
        if(service == null) {
            service = new AiApiServiceImpl(jdbi);
        }
        return service;
    }
}
