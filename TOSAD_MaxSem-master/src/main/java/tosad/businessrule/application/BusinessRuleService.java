package tosad.businessrule.application;

import tosad.businessrule.domain.AttributeCompareRule;
import tosad.businessrule.domain.AttributeRangeRule;
import tosad.businessrule.domain.BusinessRule;
import tosad.businessrule.domain.repository.BusinessRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessRuleService {
    private final BusinessRuleRepository repository;

    @Autowired
    public BusinessRuleService(BusinessRuleRepository repository) {
        this.repository = repository;
    }

    public BusinessRule createNewAttributeCompareRule (String name, String category, String type, String description, String operator) {
         AttributeCompareRule attributecomparerule = new AttributeCompareRule(name, category, type, description, operator);
         this.repository.save(attributecomparerule);
         return attributecomparerule;
    }

    public BusinessRule createNewAttributeRangeRule(String name, String category,String type, String description, String operator, int minWaarde, int maxWaarde) {
        AttributeRangeRule attributerangerule = new AttributeRangeRule(name, category, type, description, operator, minWaarde, maxWaarde);
        this.repository.save(attributerangerule);
        return attributerangerule;
    }

    public void deleteBusinessRule(String name) {
        this.repository.delete(name);
    }

}
