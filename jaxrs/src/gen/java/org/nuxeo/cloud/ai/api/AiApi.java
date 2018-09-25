package org.nuxeo.cloud.ai.api;

import org.nuxeo.cloud.ai.model.*;
import org.nuxeo.cloud.ai.api.AiApiService;
import org.nuxeo.cloud.ai.api.factories.AiApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import java.io.File;
import org.nuxeo.cloud.ai.model.Model;
import org.nuxeo.cloud.ai.model.ModelApiResponse;
import org.nuxeo.cloud.ai.model.PredictionRequest;
import org.nuxeo.cloud.ai.model.PredictionResponse;
import org.nuxeo.cloud.ai.model.TrainingRequest;

import java.util.Map;
import java.util.List;
import org.nuxeo.cloud.ai.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/ai")


@io.swagger.annotations.Api(description = "the ai API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-25T15:38:17.391Z")
public class AiApi  {
   private final AiApiService delegate;

   public AiApi(@Context ServletConfig servletContext) {
      AiApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("AiApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (AiApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = AiApiServiceFactory.getAiApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/v1/model")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Creates a new model", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "write:ai_models", description = "modify models in your account"),
            @io.swagger.annotations.AuthorizationScope(scope = "read:ai_models", description = "read your models")
        })
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 405, message = "Invalid input", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Not allowed", response = Void.class) })
    public Response addModel(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true) Model body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addModel(body,securityContext);
    }
    @DELETE
    @Path("/v1/model/{modelId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a model", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "write:ai_models", description = "modify models in your account"),
            @io.swagger.annotations.AuthorizationScope(scope = "read:ai_models", description = "read your models")
        })
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Model not found", response = Void.class) })
    public Response deleteModel(@ApiParam(value = "ID of model to update",required=true) @PathParam("modelId") String modelId
,@ApiParam(value = "" )@HeaderParam("api_key") String apiKey
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteModel(modelId,apiKey,securityContext);
    }
    @GET
    @Path("/v1/model/{modelId}")
    
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a Model by ID", notes = "Returns a single model", response = Model.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Model.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Model not found", response = Void.class) })
    public Response getModelById(@ApiParam(value = "ID of model to return",required=true) @PathParam("modelId") String modelId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getModelById(modelId,securityContext);
    }
    @GET
    @Path("/v1/model")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all the available models", notes = "", response = Model.class, responseContainer = "List", tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Model.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Model not found", response = Void.class) })
    public Response listModels(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.listModels(securityContext);
    }
    @POST
    @Path("/v1/predict/")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets a prediction from a document", notes = "", response = PredictionResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "run:ai_prediction", description = "run some predictions")
        })
    }, tags={ "AI Predict", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = PredictionResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid modelId supplied", response = Void.class) })
    public Response predict(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true) PredictionRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.predict(body,securityContext);
    }
    @POST
    @Path("/v1/model/{modelId}/train")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Train model", notes = "", response = ModelApiResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "write:ai_models", description = "modify models in your account"),
            @io.swagger.annotations.AuthorizationScope(scope = "read:ai_models", description = "read your models")
        })
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class) })
    public Response trainModel(@ApiParam(value = "ID of model to update",required=true) @PathParam("modelId") String modelId
,@ApiParam(value = "The definition of the training request" ,required=true) TrainingRequest trainingRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.trainModel(modelId,trainingRequest,securityContext);
    }
    @PUT
    @Path("/v1/model/{modelId}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an existing model", notes = "", response = Void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "write:ai_models", description = "modify models in your account"),
            @io.swagger.annotations.AuthorizationScope(scope = "read:ai_models", description = "read your models")
        })
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Model not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    public Response updateModel(@ApiParam(value = "ID of model to update",required=true) @PathParam("modelId") String modelId
,@ApiParam(value = "Model object that has to be created" ,required=true) Model body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateModel(modelId,body,securityContext);
    }
    @POST
    @Path("/v1/model/{modelId}/data")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Upload Training and Evaluation data", notes = "", response = ModelApiResponse.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "nxcloud_auth", scopes = {
            @io.swagger.annotations.AuthorizationScope(scope = "write:ai_models", description = "modify models in your account"),
            @io.swagger.annotations.AuthorizationScope(scope = "read:ai_models", description = "read your models")
        })
    }, tags={ "AI Model", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class) })
    public Response uploadEVTRData(@ApiParam(value = "ID of model to update",required=true) @PathParam("modelId") String modelId
,
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.uploadEVTRData(modelId,fileInputStream, fileDetail,securityContext);
    }
}
