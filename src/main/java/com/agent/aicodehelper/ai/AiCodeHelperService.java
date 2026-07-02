package com.agent.aicodehelper.ai;

import com.agent.aicodehelper.ai.guardrail.SafeInputGuardrail;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.guardrail.InputGuardrails;

@InputGuardrails({ SafeInputGuardrail.class})
public interface AiCodeHelperService {
    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);
}
