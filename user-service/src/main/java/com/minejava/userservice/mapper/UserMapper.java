package com.minejava.userservice.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.minejava.userservice.model.User;
import com.minejava.utilservice.payload.UserPayload;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
        @Mapping(target = "serviceAddress", ignore = true)
})
UserPayload userServiceToUserPayload(User user);

@Mappings({
        @Mapping(target = "version", ignore = true)
})
User userPayloadToUserService(UserPayload user);
}
