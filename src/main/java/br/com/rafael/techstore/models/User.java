package br.com.rafael.techstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "adresses", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name="user_id")})
    private List<Address> addresses;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(name = "user_permission", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
    //         @JoinColumn(name = "id_permission") })
    // private List<Permission> permissions;
}
