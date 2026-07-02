package com.agent.aicodehelper.ai;


import com.agent.aicodehelper.ai.mcp.McpConfig;
import com.agent.aicodehelper.ai.tools.InterviewQuestionTool;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiCodeHelperServiceFactory {
    @Resource
    private ChatModel chatModel;

    @Resource
    private ContentRetriever contentRetriever;

    @Resource
    private McpToolProvider mcpToolProvider;
    @Bean
    public AiCodeHelperService aiCodeHelperService(){
        // 会话记忆
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        AiCodeHelperService aiCodeHelperService = AiServices.builder(AiCodeHelperService.class)
                .chatModel(chatModel)
                .chatMemory(chatMemory)
                .contentRetriever(contentRetriever)//RAG 检索增强生成
                .tools(new InterviewQuestionTool())
                .toolProvider(mcpToolProvider)
                .build();
        return aiCodeHelperService;
    }
}
