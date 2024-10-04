package nttdata.primerproyecto.cuentasbancarias.CustomerMs.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
}