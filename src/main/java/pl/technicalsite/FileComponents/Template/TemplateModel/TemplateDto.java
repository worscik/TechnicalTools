package pl.technicalsite.FileComponents.Template.TemplateModel;


public class TemplateDto {


    private TemplateComponents templateComponents;

    private TemplateFields templateFields;

    public TemplateDto(TemplateComponents templateComponents, TemplateFields templateFields) {
        this.templateComponents = templateComponents;
        this.templateFields = templateFields;
    }

    public TemplateComponents getTemplateComponents() {
        return templateComponents;
    }

    public void setTemplateComponents(TemplateComponents templateComponents) {
        this.templateComponents = templateComponents;
    }

    public TemplateFields getTemplateFields() {
        return templateFields;
    }

    public void setTemplateFields(TemplateFields templateFields) {
        this.templateFields = templateFields;
    }
}
