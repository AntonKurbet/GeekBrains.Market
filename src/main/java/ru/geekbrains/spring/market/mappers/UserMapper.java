package ru.geekbrains.spring.market.mappers;

//import org.mapstruct.Mapper;
import ru.geekbrains.spring.market.model.dtos.UserDto;
import ru.geekbrains.spring.market.model.entities.User;

//@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto dto);
}
