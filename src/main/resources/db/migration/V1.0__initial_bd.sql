-- Crear secuencias para cada tabla
CREATE SEQUENCE IF NOT EXISTS repairs_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE IF NOT EXISTS repair_images_before_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE IF NOT EXISTS repair_images_after_seq
    START WITH 1
    INCREMENT BY 1;

-- Tabla repairs usando la secuencia creada
CREATE TABLE repairs (
    id BIGINT PRIMARY KEY DEFAULT nextval('repairs_seq'),
    repair_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255),
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

-- Tabla repair_images_before usando su secuencia
CREATE TABLE repair_images_before (
    id BIGINT PRIMARY KEY DEFAULT nextval('repair_images_before_seq'),
    repair_id INTEGER NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    taken_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_repair_before FOREIGN KEY (repair_id) REFERENCES repairs (id)
);

-- Tabla repair_images_after usando su secuencia
CREATE TABLE repair_images_after (
    id BIGINT PRIMARY KEY DEFAULT nextval('repair_images_after_seq'),
    repair_id INTEGER NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    taken_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_repair_after FOREIGN KEY (repair_id) REFERENCES repairs (id)
);