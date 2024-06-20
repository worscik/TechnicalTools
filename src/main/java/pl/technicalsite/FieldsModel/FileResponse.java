package pl.technicalsite.FieldsModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileResponse {

    private String result;
    private List<String> errorMessages;
    private String errorMessage;

    public FileResponse() {
    }

    public FileResponse(String result, List<String> errorMessages) {
        this.result = result;
        this.errorMessages = errorMessages;
    }

    public FileResponse(String result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
