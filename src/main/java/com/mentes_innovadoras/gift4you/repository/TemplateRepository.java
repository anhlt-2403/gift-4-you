package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {
}
