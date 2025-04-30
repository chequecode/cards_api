package DTO;

import entities.Card;
import entities.Role;

import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private Set<Role> roles;
    private List<Card> cards;

    public UserDTO(Long id, Set<Role> roles, String email, List<Card> cards, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.cards = cards;
    }

    public UserDTO() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}