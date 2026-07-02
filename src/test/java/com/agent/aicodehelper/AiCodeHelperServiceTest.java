package com.agent.aicodehelper;

import com.agent.aicodehelper.ai.AiCodeHelperService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperServiceTest {
    @Resource
    private AiCodeHelperService aiCodeHelperService;
    @Test
    void chat() {
        String result = aiCodeHelperService.chat("你好");
        System.out.println(result);
    }
    @Test
    void chatWithMemory() {
        String result = aiCodeHelperService.chat("你好，我是hdu的研究生");
        System.out.println(result);
        result = aiCodeHelperService.chat("评价一下我的学校");
        System.out.println(result);
    }
    @Test
    void chatWithTools() {
        String result = aiCodeHelperService.chat("有哪些常见的计算机网络的面试题");
        System.out.println(result);
    }

    @Test
    void chatWithMcp() {
        String result = aiCodeHelperService.chat("什么是程序员鱼皮的编程导航");
        System.out.println(result);
    }

    @Test
    void chatWithGuard(){
        String result = aiCodeHelperService.chat("love是什么意思");
        System.out.println(result);
    }
}