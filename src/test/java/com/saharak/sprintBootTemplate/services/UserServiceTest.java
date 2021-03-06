package com.saharak.sprintBootTemplate.services;

import com.saharak.sprintBootTemplate.models.User;
import com.saharak.sprintBootTemplate.repositories.UserRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

  @Mock
  private UserRepository userRepositoryMock;

  @InjectMocks
  private UserService userServiceMock;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void findByUsername() throws Exception {
    when(userRepositoryMock.findByUsername(anyString())).thenReturn(mock(User.class));
  }

  @Test
  public void findForAuthentication() throws Exception {
    when(userRepositoryMock.findForAuthentication(anyString(), anyString())).thenReturn(mock(User.class));
  }

  @Test
  public void findById() throws Exception {
    Mockito.doThrow(new RuntimeException()).when(userRepositoryMock).findById(anyLong());
  }

  @Test
  public void all() throws Exception {
    when(userRepositoryMock.findAll()).thenReturn(asList(mock(User.class)));
  }

  @Test
  public void save() throws Exception {
    when(userRepositoryMock.save(any(User.class))).thenReturn(mock(User.class));
  }

  @Test
  public void delete() throws Exception {
    Mockito.doThrow(new RuntimeException()).when(userRepositoryMock).delete(any(User.class));
  }
}