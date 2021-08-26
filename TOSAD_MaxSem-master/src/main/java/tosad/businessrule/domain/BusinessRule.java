package tosad.businessrule.domain;

public interface BusinessRule {
    String getName();
    String getCategory();
    String getType();
    String getDescription();
    String getOperator();
    int getminWaarde();
    int getmaxWaarde();

}
