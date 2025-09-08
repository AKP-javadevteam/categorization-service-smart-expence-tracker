package com.smartexpense.categorization.service;

import com.smartexpense.categorization.model.CategorizationRule;
import com.smartexpense.categorization.repository.CategorizationRuleRepository;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CategorizationServiceTest {

    @Test
    void categorize_selectsHighestPriorityMatch() {
        CategorizationRuleRepository repo = Mockito.mock(CategorizationRuleRepository.class);

        CategorizationRule r1 = new CategorizationRule();
        r1.setId(1L); r1.setPattern("star"); r1.setCategory("Misc"); r1.setPriority(1);

        CategorizationRule r2 = new CategorizationRule();
        r2.setId(2L); r2.setPattern("starbucks"); r2.setCategory("Food & Drink"); r2.setPriority(10);

        Mockito.when(repo.findAll()).thenReturn(List.of(r1, r2));

        CategorizationService svc = new CategorizationService(repo);
        var resp = svc.categorize("Purchase at Starbucks downtown");

        assertTrue(resp.isMatched());
        assertEquals("Food & Drink", resp.getCategory());
        assertEquals(2L, resp.getRuleId());
    }
}
