package top.jhana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.jhana.domain.User;
import top.jhana.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 查看用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {

        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建表单
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 增加或更新用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 获取修改用户的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("/users/form", "userModel", model);
    }
}
