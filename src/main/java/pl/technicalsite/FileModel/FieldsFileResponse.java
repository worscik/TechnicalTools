package pl.technicalsite.FileModel;

import java.util.Map;

public class FieldsFileResponse {

    private Map<String, String> list;

    public FieldsFileResponse(Map<String, String> list) {
        this.list = list;
    }

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }
}
