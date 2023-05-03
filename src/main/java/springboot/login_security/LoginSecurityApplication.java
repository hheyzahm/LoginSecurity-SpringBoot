package springboot.login_security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import springboot.login_security.web.reposiitory.RoleRepository;
import springboot.login_security.web.reposiitory.UserRepository;

@SpringBootApplication
public class LoginSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LoginSecurityApplication.class, args);
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        /*
        String password="super123";
        System.out.println("Password encoded for "+password+ " : "+this.passwordEncoder.encode(password));*/

        try {

           /* Role super_admin = new Role();
            super_admin.setId(RoleConstant.SUPER_ADMIN);
            super_admin.setName(RoleConstant.ROLE_SUPER_ADMIN);
            Role role = new Role();
            role.setId(RoleConstant.ADMIN);
            role.setName(RoleConstant.ROLE_ADMIN);

            Role role1 = new Role();
            role1.setId(RoleConstant.NORMAL);
            role1.setName(RoleConstant.ROLE_NORMAL);

            List<Role> roles = List.of(super_admin,role, role1);

            List<Role> result = this.roleRepo.saveAll(roles);

            result.forEach(r -> {
                System.out.println(r.getName());
            });*/
           /* Role role = this.roleRepo.findById(RoleConstant.SUPER_ADMIN).get();

            User user =new User();
            user.setName("Super Administrator");
            user.setEmail("super_admin@admin.com");
            user.setPassword("super123");
            user.getRoles().add(r);
            System.out.println(userRepository.save(user));
*/

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
