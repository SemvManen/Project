package tosad.businessrule.domain.repository;

import tosad.businessrule.domain.BusinessRule;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRuleRepository {
    void save(BusinessRule businessRule);
    void delete(String name);
}

