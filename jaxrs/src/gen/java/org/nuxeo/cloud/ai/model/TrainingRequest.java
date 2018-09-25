/*
 * Nuxeo Cloud AI API
 * The Nuxeo Cloud API
 *
 * OpenAPI spec version: v1
 * Contact: cloud@nuxeo.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.nuxeo.cloud.ai.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;

/**
 * TrainingRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-09-25T15:38:17.391Z")
public class TrainingRequest  implements Serializable {
  @JsonProperty("versionId")
  private String versionId = null;

  @JsonProperty("trainingData")
  private List<String> trainingData = null;

  @JsonProperty("evaluationData")
  private List<String> evaluationData = null;

  public TrainingRequest versionId(String versionId) {
    this.versionId = versionId;
    return this;
  }

  /**
   * The name of the destination TF Model version
   * @return versionId
   **/
  @JsonProperty("versionId")
  @ApiModelProperty(value = "The name of the destination TF Model version")
  public String getVersionId() {
    return versionId;
  }

  public void setVersionId(String versionId) {
    this.versionId = versionId;
  }

  public TrainingRequest trainingData(List<String> trainingData) {
    this.trainingData = trainingData;
    return this;
  }

  public TrainingRequest addTrainingDataItem(String trainingDataItem) {
    if (this.trainingData == null) {
      this.trainingData = new ArrayList<>();
    }
    this.trainingData.add(trainingDataItem);
    return this;
  }

  /**
   * Get trainingData
   * @return trainingData
   **/
  @JsonProperty("trainingData")
  @ApiModelProperty(value = "")
  public List<String> getTrainingData() {
    return trainingData;
  }

  public void setTrainingData(List<String> trainingData) {
    this.trainingData = trainingData;
  }

  public TrainingRequest evaluationData(List<String> evaluationData) {
    this.evaluationData = evaluationData;
    return this;
  }

  public TrainingRequest addEvaluationDataItem(String evaluationDataItem) {
    if (this.evaluationData == null) {
      this.evaluationData = new ArrayList<>();
    }
    this.evaluationData.add(evaluationDataItem);
    return this;
  }

  /**
   * Get evaluationData
   * @return evaluationData
   **/
  @JsonProperty("evaluationData")
  @ApiModelProperty(value = "")
  public List<String> getEvaluationData() {
    return evaluationData;
  }

  public void setEvaluationData(List<String> evaluationData) {
    this.evaluationData = evaluationData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainingRequest trainingRequest = (TrainingRequest) o;
    return Objects.equals(this.versionId, trainingRequest.versionId) &&
        Objects.equals(this.trainingData, trainingRequest.trainingData) &&
        Objects.equals(this.evaluationData, trainingRequest.evaluationData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(versionId, trainingData, evaluationData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainingRequest {\n");
    
    sb.append("    versionId: ").append(toIndentedString(versionId)).append("\n");
    sb.append("    trainingData: ").append(toIndentedString(trainingData)).append("\n");
    sb.append("    evaluationData: ").append(toIndentedString(evaluationData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

