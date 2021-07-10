package com.poc.media.api;

import static org.springframework.hateoas.server.core.WebHandler.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.poc.media.PocMediaOas3Application;
import com.poc.media.model.InlineResponse201;
import com.poc.media.model.User;
import io.swagger.annotations.Api;
import java.util.Optional;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
@Api(value = "users")
public class UsersApiImpl implements UsersApi {

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return UsersApi.super.getRequest();
  }

  /**
   * POST /users : Creates a user and returns the user ID
   *
   * @param user A JSON object that contains the user name and age. (required)
   * @return Created (status code 201)
   */
  @Override
  public ResponseEntity<InlineResponse201> createUser(User user) {
    user.setId(111L);
    InlineResponse201 inlineResponse201 = new InlineResponse201();
    inlineResponse201.setId(user.getId());
    inlineResponse201.add( Link.of("/{segment}/something{?parameter}"));
    return new ResponseEntity<>(inlineResponse201, HttpStatus.CREATED);
  }

  /**
   * GET /users/{userId} : Gets a user by ID
   *
   * @param userId (required)
   * @return A User object (status code 200)
   */
  @Override
  public ResponseEntity<User> getUser(Long userId) {
    return UsersApi.super.getUser(userId);
  }
}
