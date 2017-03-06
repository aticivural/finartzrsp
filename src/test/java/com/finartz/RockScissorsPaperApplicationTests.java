package com.finartz;

import com.finartz.WEB.controller.GameController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RockScissorsPaperApplicationTests {
	@Autowired
    GameController gameController;

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads()throws Exception{
        assertThat(gameController).isNotNull();
	}

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        String expected = "{\"status\":\"ok\"}";
        this.mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }


    @Test
    public void scissors_vs_rock() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"scissors\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"rock\"}";
        String expected = "{\"message\":\"Utku won the game\",\"winner\":\"Utku\",\"firstPlayerWins\":false,\"secondPlayerWins\":true}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void paper_vs_scissors() throws Exception {

        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"paper\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"scissors\"}";
        String expected = "{\"message\":\"Utku won the game\",\"winner\":\"Utku\",\"firstPlayerWins\":false,\"secondPlayerWins\":true}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void paper_vs_rock() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"paper\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"rock\"}";
        String expected = "{\"firstPlayerWins\":true,\"secondPlayerWins\":false,\"message\":\"Arif won the game\",\"winner\":\"Arif\"}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void rock_vs_paper() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"rock\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"paper\"}";
        String expected = "{\"message\":\"Utku won the game\",\"winner\":\"Utku\",\"firstPlayerWins\":false,\"secondPlayerWins\":true}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void scissors_vs_paper() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"scissors\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"paper\"}";
        String expected = "{\"message\":\"Arif won the game\",\"winner\":\"Arif\",\"firstPlayerWins\":true,\"secondPlayerWins\":false}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void paper_vs_paper() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"paper\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"paper\"}";
        String expected = "{\"message\":\"Arif and Utku made same move.\",\"winner\":\"\",\"firstPlayerWins\":false,\"secondPlayerWins\":false}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }

    @Test
    public void scissors_vs_scissors() throws Exception {
        String request = "{\"firstPlayerName\":\"Arif\",\"firstPlayerMove\":\"scissors\",\"secondPlayerName\":\"Utku\",\"secondPlayerMove\":\"scissors\"}";
        String expected = "{\"message\":\"Arif and Utku made same move.\",\"winner\":\"\",\"firstPlayerWins\":false,\"secondPlayerWins\":false}";

        this.mockMvc.perform(post("/game/play").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andDo(print());
    }


}
