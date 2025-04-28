package DTO;

import entities.Card;
import enums.RoleTypes;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private RoleTypes role;
    private List<Card> cards;

    public UserDTO(Long id, String name, String email, RoleTypes role, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.cards = cards;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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