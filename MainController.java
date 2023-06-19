import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Part;
import java.io.IOException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/user")
    public String saveUser(@ModelAttribute User user, @RequestPart("file") Part file) throws IOException {
        // Save the user to the database
        userRepository.save(user);

        // Process the uploaded file
        if (file != null && file.getSize() > 0) {
            // Save the file or perform further processing
        }

        return "redirect:/user";
    }
}
