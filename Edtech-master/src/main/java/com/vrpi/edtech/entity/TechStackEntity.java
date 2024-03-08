package com.vrpi.edtech.entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "tech_stack_entity")
public  class TechStackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private  Long id;

    @Column(name = "title", columnDefinition = "VARCHAR")
    private  String title;

    @Column(name = "stacks", columnDefinition = "VARCHAR")
    private  String stacks;

    @ManyToOne
    @JoinColumn(name = "tools_and_technology_used_entity_id")
    private  ToolsAndTechnologyUsedEntity toolsAndTechnologyUsedEntity;
}