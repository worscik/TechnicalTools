package pl.technicalsite.FileModel;

import org.springframework.http.HttpStatus;

public class FileResponse extends ErrorResponse {

    private String xsltFile;
    private HttpStatus httpStatus;


    public FileResponse(String errorMsg, HttpStatus httpStatus) {
        super(errorMsg);
        this.xsltFile = xsltFile;
        this.httpStatus = httpStatus;
    }


}
