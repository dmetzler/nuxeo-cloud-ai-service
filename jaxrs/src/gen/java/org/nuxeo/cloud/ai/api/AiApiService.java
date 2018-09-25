package org.nuxeo.cloud.ai.api;

import org.nuxeo.cloud.ai.api.*;
import org.nuxeo.cloud.ai.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.io.File;
import org.nuxeo.cloud.ai.model.Model;
import org.nuxeo.cloud.ai.model.ModelApiResponse;
import org.nuxeo.cloud.ai.model.PredictionRequest;
import org.nuxeo.cloud.ai.model.PredictionResponse;
import org.nuxeo.cloud.ai.model.TrainingRequest;

import java.util.List;
import org.nuxeo.cloud.ai.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-25T15:38:17.391Z")
public abstract class AiApiService {
    public abstract Response addModel(Model body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteModel(String modelId,String apiKey,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getModelById(String modelId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listModels(SecurityContext securityContext) throws NotFoundException;
    public abstract Response predict(PredictionRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response trainModel(String modelId,TrainingRequest trainingRequest,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateModel(String modelId,Model body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response uploadEVTRData(String modelId,InputStream fileInputStream, FormDataContentDisposition fileDetail,SecurityContext securityContext) throws NotFoundException;
}
