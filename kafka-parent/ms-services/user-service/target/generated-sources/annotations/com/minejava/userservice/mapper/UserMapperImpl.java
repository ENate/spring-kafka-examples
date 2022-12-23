package com.minejava.userservice.mapper;

import com.minejava.userservice.model.User;
import com.minejava.utilservice.payload.UserPayload;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-23T17:40:57+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserPayload userServiceToUserPayload(User user) {
        if ( user == null ) {
            return null;
        }

        UserPayload userPayload = new UserPayload();

        userPayload.setEmail( user.getEmail() );
        userPayload.setId( user.getId() );
        userPayload.setName( user.getName() );
        userPayload.setUsername( user.getUsername() );

        return userPayload;
    }

    @Override
    public User userPayloadToUserService(UserPayload user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( user.getId() );
        user1.setUsername( user.getUsername() );
        user1.setEmail( user.getEmail() );
        user1.setName( user.getName() );

        return user1;
    }
}
