package com.example.travelAgency.service.impl;

import com.example.travelAgency.constraint.MessageConstraint;
import com.example.travelAgency.constraint.RoleConstraint;
import com.example.travelAgency.dto.loginDTOs.LoginDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterClientDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterStaffDTO;
import com.example.travelAgency.entity.Client;
import com.example.travelAgency.entity.Role;
import com.example.travelAgency.entity.Staff;
import com.example.travelAgency.entity.User;
import com.example.travelAgency.repository.ClientRepository;
import com.example.travelAgency.repository.RoleRepository;
import com.example.travelAgency.repository.StaffRepository;
import com.example.travelAgency.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;

    public String login(LoginDTO loginDTO){
        String usernameOrEmail;
        if (loginDTO.getUsername()!=null){
            usernameOrEmail=loginDTO.getUsername();
        }else {
            usernameOrEmail=loginDTO.getEmail();
        }

        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(usernameOrEmail,loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "E Logged In";
    }

    @Transactional
    public String register(RegisterClientDTO registerClientDTO){

        if (userRepository.findByUsernameOrEmail(registerClientDTO.getUsername(),registerClientDTO.getEmail()).isPresent()){
            throw new RuntimeException(MessageConstraint.USER_ALREADY_EXISTS);
        }
            User newUser = new User();
            newUser.setUsername(registerClientDTO.getUsername());
            newUser.setEmail(registerClientDTO.getEmail());
            newUser.setPassword(passwordEncoder.encode(registerClientDTO.getPassword()));

            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_USER").orElseThrow(() -> new RuntimeException(RoleConstraint.user)));
            newUser.setRole(roles);

            Client newClient = new Client();
            newClient.setClientName(registerClientDTO.getClientName());
            newClient.setPhoneNumber(registerClientDTO.getPhoneNumber());
            clientRepository.save(newClient);

            newUser.setClient(newClient);
            userRepository.save(newUser);

            return "E Client";
    }

    @Transactional
    public String registerStaff(RegisterStaffDTO registerStaffDTO){

        if (userRepository.findByUsernameOrEmail(registerStaffDTO.getUsername(),registerStaffDTO.getEmail()).isPresent()){
            throw new RuntimeException("Exists");
        }
        User newUser = new User();
        newUser.setUsername(registerStaffDTO.getUsername());
        newUser.setEmail(registerStaffDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerStaffDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("ROLE_STAFF").orElseThrow(() -> new RuntimeException("Role not found")));
        newUser.setRole(roles);

        Staff newStaff = new Staff();
        newStaff.setStaffName(registerStaffDTO.getStaffName());
        newStaff.setPhoneNumber(registerStaffDTO.getPhoneNumber());
        newStaff.setExperienceYears(registerStaffDTO.getExperienceYears());

        staffRepository.save(newStaff);

        newUser.setStaff(newStaff);
        userRepository.save(newUser);

        return "E Staff";
    }
}
