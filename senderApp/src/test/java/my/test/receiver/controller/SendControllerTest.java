package my.test.receiver.controller;

import static org.assertj.core.api.Assertions.assertThat;

import my.test.receiver.POJO.MyMessage;
import my.test.receiver.service.SenderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(SendController.class)
class SendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SenderService senderService;

    private final String testString = "test message";

    @Test
    void sendMessageToKafkaTopicTest() throws Exception {
        Mockito.when(senderService.sendMessage(new MyMessage(testString)))
                .thenReturn(testString);
        this.mockMvc.perform(get("/?q=" + testString + "&submit=SEND"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}