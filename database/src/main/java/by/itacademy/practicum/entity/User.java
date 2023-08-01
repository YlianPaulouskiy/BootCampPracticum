package by.itacademy.practicum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "practicum")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "mid_name", nullable = false, length = 40)
    private String midName;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

}
