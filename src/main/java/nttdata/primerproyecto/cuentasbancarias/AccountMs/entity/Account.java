package nttdata.primerproyecto.cuentasbancarias.AccountMs.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroCuenta;
    private Double saldo;
    private String tipoCuenta;
    private Integer clienteId;
}