package org.nuxeo.cloud.ai.api.impl;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.jdbi.v3.core.Jdbi;
import org.nuxeo.cloud.ai.api.AiApiService;
import org.nuxeo.cloud.ai.api.ApiResponseMessage;
import org.nuxeo.cloud.ai.api.NotFoundException;
import org.nuxeo.cloud.ai.db.ModelDAO;

import org.nuxeo.cloud.ai.model.Model;
import org.nuxeo.cloud.ai.model.PredictionRequest;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-21T04:16:44.923Z")
public class AiApiServiceImpl extends AiApiService {
        ModelDAO dao;

    public AiApiServiceImpl(Jdbi jdbi) {
        dao = jdbi.onDemand(ModelDAO.class);
    }
    @Override
    public Response addModel(Model body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response deleteModel(String modelId, String apiKey, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getModelById(String modelId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response predict(PredictionRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response trainModel(String modelId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response updateModel(String modelId, Model body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
//    @Override
    public Response uploadEVTRData(String modelId, InputStream fileInputStream, FormDataContentDisposition fileDetail, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
