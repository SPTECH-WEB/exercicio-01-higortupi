package com.faturas.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "faturas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "\\d{16}", message = "Deve conter exatamente 16 dígitos")
    private String numeroCartao;

    @NotBlank
    @Size(min = 3, max = 100, message = "O valor deve ser entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull
    @DecimalMin(value = "10.00", message = "O mínimo deve ser 10,00")
    @DecimalMax(value = "5000.0", message = "O máximo deve ser 5000,00")
    private Double valor;

    @NotNull
    @FutureOrPresent
    private LocalDate dataPagamento;

    @NotBlank
    @Email
    private String emailContato;
}
