package pl.technicalsite.FileModel;

import java.util.List;

public class FileResponse {

    private String result;
    private List<String> errorMessages;

    public FileResponse() {
    }

    public FileResponse(String result, List<String> errorMessages) {
        this.result = result;
        this.errorMessages = errorMessages;
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
}
