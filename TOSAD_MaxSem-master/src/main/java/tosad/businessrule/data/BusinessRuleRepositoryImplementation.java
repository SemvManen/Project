package tosad.businessrule.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tosad.businessrule.domain.BusinessRule;
import tosad.businessrule.domain.repository.BusinessRuleNotFoundException;
import tosad.businessrule.domain.repository.BusinessRuleRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessRuleRepositoryImplementation implements BusinessRuleRepository {
    private Map<String, BusinessRule> businessrules = new HashMap<>();

    private JDBC dataconnectie;

    @Autowired
    public BusinessRuleRepositoryImplementation(JDBC dataconnectie) {
        this.dataconnectie = dataconnectie;
    }


    @Override
    public void save(BusinessRule businessRule) {
        dataconnectie.updateQuery("insert into businessrule VALUES ('"+businessRule.getName()+"', '"+businessRule.getCategory()+"', '"+businessRule.getType()+"', '"+businessRule.getDescription()+"', '"+businessRule.getOperator()+"', "+businessRule.getminWaarde()+", "+businessRule.getmaxWaarde()+");");
        this.businessrules.put(businessRule.getName(), businessRule);
    }

    @Override
    public void delete(String name) {
        if (!this.businessrules.containsKey(name)) {
            throw new BusinessRuleNotFoundException();
        }

        this.businessrules.remove(name);
    }
}
