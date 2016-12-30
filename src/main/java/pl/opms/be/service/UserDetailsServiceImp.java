package pl.opms.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.UserEntity;
import pl.opms.be.repository.UserRepository;

/**
 * Created by Dawid on 30.12.2016 at 12:42.
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws CredentialsExpiredException, UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(s);

        if (userEntity == null) {
            throw new UsernameNotFoundException(s + " is not found");
        }

        return new User(s, userEntity.getPassword(), true, true, true, true, userEntity.getRoleEntity().getPrivilegeEntities());
    }
}
