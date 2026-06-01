package com.agent.aicodehelper;

import com.agent.aicodehelper.ai.AiCodeHelper;
import com.alibaba.dashscope.threads.ContentText;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperApplicationTests {
    @Resource
    private AiCodeHelper aiCodeHelper;
    @Test
    void contextLoads() {
    }

    @Test
    void chat() {
        aiCodeHelper.chat("面试要准备的八股文，除了计算机网络还有啥");
    }

    @Test
    void chatWithMessage() {
        UserMessage userMessage = UserMessage.from(
                TextContent.from("描述图片"),
                ImageContent.from("图片/Nakamachi_Arale.webp")
        );
        aiCodeHelper.chatWithMessage(userMessage);
    }
}
