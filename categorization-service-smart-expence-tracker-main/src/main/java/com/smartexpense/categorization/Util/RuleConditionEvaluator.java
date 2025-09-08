package com.smartexpense.categorization.Util;

import com.smartexpense.categorization.dto.TransactionDto;
import com.smartexpense.categorization.domain.Rule;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RuleConditionEvaluator {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static boolean matches(Rule rule, TransactionDto txn) {
        if (rule.getConditionsJson() == null) return false;

        try {
            JsonNode conditions = mapper.readTree(rule.getConditionsJson());

            if (conditions.has("merchantContains")) {
                String keyword = conditions.get("merchantContains").asText();
                if (txn.getMerchant() == null || !txn.getMerchant().contains(keyword)) {
                    return false;
                }
            }

            if (conditions.has("mccEquals")) {
                String mcc = conditions.get("mccEquals").asText();
                if (!mcc.equals(txn.getMcc())) {
                    return false;
                }
            }

            // ✅ Add more condition checks here as DSL evolves

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


public class RuleConditionEvaluator {
}
