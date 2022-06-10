package com.nix.ybrcrudapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class YbrCrudAppApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getsAllUsers() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/user")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andReturn();
  }

  @Test
  public void getsSingleUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andReturn();
  }

  @Test
  public void returnsNotFoundForInvalidSingleUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/user/6")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isNotFound())
           .andReturn();
  }

  @Test
  public void removesSingleUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/user/2")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andReturn();
  }

  @Test
  public void addsNewUser() throws Exception {
    String newRide = "{\"name\":\"Test User\"}";
    mockMvc.perform(MockMvcRequestBuilders.post("/user")
                                          .contentType(MediaType.APPLICATION_JSON)
                                          .content(newRide)
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isCreated())
           .andReturn();
  }
}
