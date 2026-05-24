CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,

                       email VARCHAR(255) NOT NULL,
                       CONSTRAINT uk_users_email UNIQUE (email),

                       password_hash VARCHAR(255) NOT NULL,

                       version BIGINT NOT NULL DEFAULT 0,

                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);