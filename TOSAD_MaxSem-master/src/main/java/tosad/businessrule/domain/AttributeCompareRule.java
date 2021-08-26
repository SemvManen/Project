package tosad.businessrule.domain;

public class AttributeCompareRule implements BusinessRule {
    private String name;
    private String category;
    private String type;
    private String description;
    private String operator;


    public AttributeCompareRule(String name, String category, String type, String description, String operator) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.description = description;
        this.operator = operator;
    }

    @Override
    public String getName() {return this.name; }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getOperator() {
        return this.operator;
    }

    @Override
    public int getminWaarde() {
        return this.getminWaarde();
    }

    @Override
    public int getmaxWaarde() {
        return this.getmaxWaarde();
    }

    @Override
    public String getType() {
        return this.type;
    }

}
