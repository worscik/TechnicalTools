package pl.technicalsite.FileModel;

import java.util.Map;

public class ReadFileResponse {

    private Map<String, String> list;
    private String result;

    public ReadFileResponse() {
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
}
