package entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import enums.RoleTypes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleTypes role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> cards;

    public User() {}

    public User(Long id, String email, String password, RoleTypes role, List<Card> cards) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cards = cards;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
