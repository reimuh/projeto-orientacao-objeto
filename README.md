# Projeto Imobiliária (Spring Boot MVC)

## Estrutura MVC

- **Model**: Entidades do banco (`UserModel`, `PropertyModel`, `AddressModel`) com JPA/Hibernate.

  - Relacionamentos:
    - `PropertyModel` → `@ManyToOne` `owner` (User) e `address` (Address).
    - `AddressModel` salvo em cascata (`CascadeType.ALL`).

- **Repository**: Interfaces que estendem `JpaRepository` para CRUD e consultas derivadas.

- **Service**: Lógica de negócio, valida dados e gerencia relacionamentos.

  - Exemplo: `PropertyService` atribui `owner` e salva `address` em cascata.

- **Controller**: Endpoints REST (`@RestController`) que recebem DTOs e chamam os serviços.

---

## Banco de Dados

- **PostgreSQL** usado como backend.
- **Flyway** para versionamento de migrations SQL:

```bash
src/main/resources/db/migration/
├── V1__create_users_table.sql
└── V2__create_properties_table.sql
```

- UUID para chaves primárias.  
- Timestamps (`created_at`, `updated_at`) atualizados automaticamente via `@PreUpdate` ou `Builder.Default`.

---

## Relações importantes

- **Property ↔ User** (`owner`): `@ManyToOne`, NOT NULL, sem cascade.  
- **Property ↔ Address** (`address`): `@ManyToOne`, com `CascadeType.ALL`.
