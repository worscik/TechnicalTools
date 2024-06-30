package pl.technicalsite.FieldsModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileResponse {

    private String result;
    private boolean success;
    private List<String> errorMessages;
    private String errorMessage;

    public FileResponse() {
    }

    public FileResponse(String result, boolean success, String errorMessage) {
        this.result = result;
        this.success = success;
        this.errorMessage = errorMessage;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "result='" + result + '\'' +
                ", success=" + success +
                ", errorMessages=" + errorMessages +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
