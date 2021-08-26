package tosad.businessrule.presentation;


import tosad.businessrule.application.BusinessRuleService;
import tosad.businessrule.domain.AttributeCompareRule;
import tosad.businessrule.domain.AttributeRangeRule;
import tosad.businessrule.presentation.DTO.CreateCompareRequest;
import tosad.businessrule.presentation.DTO.CreateRangeRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/businessrules")
public class BusinessRuleController {
    private final BusinessRuleService service;

    public BusinessRuleController(BusinessRuleService service) {
        this.service = service;
    }

    @PostMapping("/attributerange")
    public AttributeRangeRule newAttributeRangeRule(@Valid @RequestBody CreateRangeRequest request) {

        return (AttributeRangeRule) this.service.createNewAttributeRangeRule(
                request.name,
                request.category,
                request.description,
                request.operator,
                request.type,
                request.minWaarde,
                request.maxWaarde);
    }

    @PostMapping("/attributecompare")
    public AttributeCompareRule newAttributeCompareRule(@Valid @RequestBody CreateCompareRequest request) {
        return (AttributeCompareRule) this.service.createNewAttributeCompareRule(
                request.name,
                request.category,
                request.description,
                request.type,
                request.operator);
    }

    @DeleteMapping("/{name}")
    public void deleteBusinessRule(@PathVariable String name) {
        this.service.deleteBusinessRule(name);
    }

    // TODO: 25/08/2021 schrijf requests voor het systeem
}
