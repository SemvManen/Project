package tosad.businessrule.domain;

public class AttributeRangeRule implements BusinessRule {
    private String name;
    private String category;
    private String type;
    private String description;
    private String operator;
    private int minWaarde;
    private int maxWaarde;


    public AttributeRangeRule(String name, String category, String type, String description, String operator, int minWaarde, int maxWaarde) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.description = description;
        this.operator = operator;
        this.minWaarde = minWaarde;
        this.maxWaarde = maxWaarde;
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
    public String getType() {
        return this.type;
    }

    @Override
    public int getminWaarde() {return this.minWaarde; }

    @Override
    public int getmaxWaarde() {return this.maxWaarde; }
}
