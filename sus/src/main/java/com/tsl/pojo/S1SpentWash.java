package com.tsl.pojo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "s1_spent_wash")
@Data
public class S1SpentWash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    
    private String year;
    
    @Column(name = "spent_wash_gen")
    private double monthlySpentWashGenerated;

    @Column(name = "spent_wash_used_in_comp")
    private double monthlySpentWashUsedInComposting;
    
    @ManyToOne
    @JoinColumn(name = "login_id")
  
    private Login login;
}
