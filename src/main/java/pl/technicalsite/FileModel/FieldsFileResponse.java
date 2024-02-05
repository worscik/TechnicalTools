package pl.technicalsite.FileModel;

import java.util.Map;

public class FieldsFileResponse {

    private Map<String, String> list;
    private String result;
    private boolean success;

    private FieldsFileResponse(Map<String, String> list, boolean success) {
        this.list = list;
        this.success = success;
    }

    public FieldsFileResponse(String result, boolean success) {
        this.result = result;
        this.success = success;
    }

    public static FieldsFileResponse createResponse(Map<String, String> list, boolean success) {
       return new FieldsFileResponse(list,success);
    }

    public static FieldsFileResponse createErrorResponse(String result, boolean success) {
        return new FieldsFileResponse(result,success);
    }

    public FieldsFileResponse(Map<String, String> list) {
        this.list = list;
    }

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
