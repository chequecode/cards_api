package DTO;

import entities.Card;
import enums.RoleTypes;

import java.util.List;

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private RoleTypes role;
    private List<Card> cards;

    public UserDTO(Long id, String email, RoleTypes role, List<Card> cards, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public RoleTypes getRole() {
        return role;
    }

    public void setRole(RoleTypes role) {
        this.role = role;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}