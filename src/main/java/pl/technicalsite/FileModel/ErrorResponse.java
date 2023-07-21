package pl.technicalsite.FileModel;

public class ErrorResponse {

    private String errorMsg;

    public ErrorResponse(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
