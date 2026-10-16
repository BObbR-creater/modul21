package Middle.Middle1.Service;

import Middle.Middle1.Model.User;
import Middle.Middle1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(String login, String password) {

        User foundUser = userRepository.findByLogin(login);

        if (foundUser == null){
            return "Failed";
        }

        if (!foundUser.getPassword().equals(password)){
            return "Failed";
        }

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        userRepository.save(user);
        return "Success";
    }


}
